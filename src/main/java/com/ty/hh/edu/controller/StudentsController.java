package com.ty.hh.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ty.hh.edu.common.PageResult;
import com.ty.hh.edu.common.Result;
import com.ty.hh.edu.model.req.RegisterRequest;
import com.ty.hh.edu.model.req.StudentPageRequest;
import com.ty.hh.edu.model.req.StudentRequest;
import com.ty.hh.edu.model.res.AuthResponse;
import com.ty.hh.edu.model.res.StudentResponse;
import com.ty.hh.edu.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 学员详细信息表 前端控制器
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentsController {


    private final StudentsService studentsService;

    @PostMapping("/create")
    public Result<Void> create(@RequestBody @Valid StudentRequest request) {
        studentsService.create(request);
        return Result.success("创建成功");
    }

    @PutMapping("/update")
    public Result<Void> update(@PathVariable Long id,@RequestBody @Valid StudentRequest request) {
        studentsService.updateStudent(id,request);
        return Result.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        studentsService.delete(id);
        return Result.success("删除成功");
    }

    @GetMapping("/{id}")
    public Result<StudentResponse> select(@PathVariable Long id) {
        StudentResponse result = studentsService.selectStudent(id);
        return Result.success(result);
    }

    @PostMapping("/page")
    public Result<PageResult<StudentResponse>> list(@RequestBody @Valid StudentPageRequest request) {
        PageResult<StudentResponse> result = studentsService.pageStudent(request);
        return Result.success(result);
    }


}
