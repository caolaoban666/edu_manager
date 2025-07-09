package com.ty.hh.edu.service.impl;

import com.ty.hh.edu.mapper.UsersMapper;
import com.ty.hh.edu.model.entity.UsersEntity;
import com.ty.hh.edu.model.req.LoginRequest;
import com.ty.hh.edu.model.req.RegisterRequest;
import com.ty.hh.edu.model.res.AuthResponse;
import com.ty.hh.edu.service.AuthService;
import com.ty.hh.edu.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final UsersMapper usersMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final RedisTemplate<String, String> redisTemplate;

    private static final String TOKEN_BLACKLIST_PREFIX = "token:blacklist:";


    @Override
    public AuthResponse register(RegisterRequest request) {

        UsersEntity usersEntity  = usersMapper.selectByPhone(request.getPhone());
        if(usersEntity!=null){
            throw new RuntimeException("用户名已存在");
        }

        usersEntity = new UsersEntity();
        usersEntity.setUsername(request.getUsername());
        usersEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        usersEntity.setPhone(request.getPhone());
//        usersEntity.setRole("ROLE_USER");
        usersMapper.insert(usersEntity);

        String token = jwtUtil.generateToken(usersEntity);
        return new AuthResponse(token, usersEntity.getUsername(), usersEntity.getRole());
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        UsersEntity usersEntity = usersMapper.selectByPhone(request.getPhone());
        if(usersEntity!=null && passwordEncoder.matches(request.getPassword(), usersEntity.getPassword())){
            String jwt = jwtUtil.generateToken(usersEntity);
            return new AuthResponse(jwt, usersEntity.getUsername(), usersEntity.getRole());
        }else{
            throw new RuntimeException("用户名或密码错误");
        }
    }

    @Override
    public void logout(String token) {
        // 可选：将token加入 Redis 黑名单，有效期为 token 的剩余时间
        Date expireDate = jwtUtil.getExpirationDate(token);
        long ttl = expireDate.getTime() - System.currentTimeMillis();
        if (ttl > 0) {
            redisTemplate.opsForValue().set(TOKEN_BLACKLIST_PREFIX + token, "1", ttl, TimeUnit.MILLISECONDS);
        }
    }
}
