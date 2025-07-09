package com.ty.hh.edu.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表，存储登录信息及角色
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("users")
public class UsersEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID，主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录用户名，唯一
     */
    @TableField("username")
    private String username;

    /**
     * 加密后的登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户角色，学员或管理员
     */
    @TableField("role")
    private String role;

    /**
     * 微信openid，用于微信授权登录
     */
    @TableField("wx_openid")
    private String wxOpenid;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}
