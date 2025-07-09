package com.ty.hh.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ty.hh.edu.common.PageResult;
import com.ty.hh.edu.model.entity.StudentsEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ty.hh.edu.model.req.RegisterRequest;
import com.ty.hh.edu.model.req.StudentPageRequest;
import com.ty.hh.edu.model.req.StudentRequest;
import com.ty.hh.edu.model.res.StudentResponse;

/**
 * <p>
 * 学员详细信息表 服务类
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
public interface StudentsService extends IService<StudentsEntity> {

    void create(StudentRequest request);

    void updateStudent(Long id, StudentRequest request);

    void delete(Long id);

    StudentResponse selectStudent(Long id);

    PageResult<StudentResponse> pageStudent(StudentPageRequest request);
}
