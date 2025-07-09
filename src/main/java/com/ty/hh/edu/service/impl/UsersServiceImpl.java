package com.ty.hh.edu.service.impl;

import com.ty.hh.edu.model.entity.UsersEntity;
import com.ty.hh.edu.mapper.UsersMapper;
import com.ty.hh.edu.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表，存储登录信息及角色 服务实现类
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersEntity> implements UsersService {

}
