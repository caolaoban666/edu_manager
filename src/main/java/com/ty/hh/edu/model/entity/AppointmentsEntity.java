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
 * 学员课程预约表
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("appointments")
public class AppointmentsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预约记录ID，主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学员ID
     */
    @TableField("student_id")
    private Long studentId;

    /**
     * 课程ID
     */
    @TableField("course_id")
    private Long courseId;

    /**
     * 预约时间
     */
    @TableField("appointment_time")
    private LocalDateTime appointmentTime;

    /**
     * 预约状态，待确认/已确认/已取消
     */
    @TableField("status")
    private String status;

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
