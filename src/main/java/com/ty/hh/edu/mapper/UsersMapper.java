package com.ty.hh.edu.mapper;

import com.ty.hh.edu.model.entity.UsersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表，存储登录信息及角色 Mapper 接口
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
public interface UsersMapper extends BaseMapper<UsersEntity> {

    UsersEntity selectByPhone(String phone);
}
