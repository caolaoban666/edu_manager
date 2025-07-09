package com.ty.hh.edu.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学员详细信息表
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("students")
public class StudentsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学员ID，与users表id对应
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID，与users表id对应
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 学员全名
     */
    @TableField("full_name")
    private String fullName;

    /**
     * 性别
     */
    @TableField("gender")
    private String gender;

    /**
     * 电子邮件
     */
    @TableField("email")
    private String email;

    /**
     * 出生日期
     */
    @TableField("birthday")
    private LocalDate birthday;

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
