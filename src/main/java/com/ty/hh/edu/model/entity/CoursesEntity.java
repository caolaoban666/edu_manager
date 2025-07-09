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
 * 课程信息表
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("courses")
public class CoursesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程ID，主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程名称
     */
    @TableField("course_name")
    private String courseName;

    /**
     * 课程描述
     */
    @TableField("description")
    private String description;

    /**
     * 授课老师
     */
    @TableField("teacher")
    private String teacher;

    /**
     * 最大可报名人数，0表示不限
     */
    @TableField("max_students")
    private Integer maxStudents;

    /**
     * 课程开始日期
     */
    @TableField("start_date")
    private LocalDate startDate;

    /**
     * 课程结束日期
     */
    @TableField("end_date")
    private LocalDate endDate;

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
