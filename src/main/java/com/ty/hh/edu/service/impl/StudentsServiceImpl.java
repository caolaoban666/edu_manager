package com.ty.hh.edu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ty.hh.edu.common.PageResult;
import com.ty.hh.edu.holder.UserContextHolder;
import com.ty.hh.edu.model.entity.StudentsEntity;
import com.ty.hh.edu.mapper.StudentsMapper;
import com.ty.hh.edu.model.req.StudentPageRequest;
import com.ty.hh.edu.model.req.StudentRequest;
import com.ty.hh.edu.model.res.StudentResponse;
import com.ty.hh.edu.service.StudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 学员详细信息表 服务实现类
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
@Service
@RequiredArgsConstructor
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, StudentsEntity> implements StudentsService {


    private final StudentsMapper studentsMapper;

    @Override
    public void create(StudentRequest request) {

        Long userId = UserContextHolder.getUserId();
        List<StudentsEntity> studentList = studentsMapper.listByUserId(userId);
        if(CollUtil.isNotEmpty(studentList)){
            long count = studentList.stream().filter(student -> student.getFullName().equals(request.getName())).count();
            if(count > 0 ){
                throw new RuntimeException("用户已绑定该学员["+request.getName()+"]！");
            }
        }

        StudentsEntity student = new StudentsEntity();
        student.setUserId(userId);
        student.setFullName(request.getName());
        student.setGender(request.getGender());
        student.setEmail(request.getEmail());
        student.setBirthday(request.getBirthday());
        studentsMapper.insert(student);
    }

    @Override
    public void updateStudent(Long id, StudentRequest request) {

        StudentsEntity students = studentsMapper.selectById(id);
        if(students == null){
            throw new RuntimeException("该学员不存在");
        }

        students.setFullName(request.getName());
        students.setGender(request.getGender());
        students.setEmail(request.getEmail());
        students.setBirthday(request.getBirthday());
        studentsMapper.updateById(students);
    }

    @Override
    public void delete(Long id) {

        StudentsEntity students = studentsMapper.selectById(id);
        if(students == null){
            throw new RuntimeException("该学员不存在");
        }
        studentsMapper.deleteById(id);
    }

    @Override
    public StudentResponse selectStudent(Long id) {
        StudentsEntity students = studentsMapper.selectById(id);
        return BeanUtil.copyProperties(students, StudentResponse.class);
    }

    @Override
    public PageResult<StudentResponse> pageStudent(StudentPageRequest request) {
        // 构建分页参数
        Page<StudentsEntity> page = new Page<>(request.getPageNo(), request.getPageSize());

        // 构建查询条件
        LambdaQueryWrapper<StudentsEntity> queryWrapper = Wrappers.lambdaQuery(StudentsEntity.class)
                .like(StrUtil.isNotBlank(request.getName()), StudentsEntity::getFullName, request.getName())
                .orderByDesc(StudentsEntity::getCreatedAt);

        // 执行分页查询
        Page<StudentsEntity> resultPage = studentsMapper.selectPage(page, queryWrapper);

        // 使用 Hutool 拷贝实体 -> DTO
        List<StudentResponse> list = resultPage.getRecords().stream()
                .map(student -> BeanUtil.copyProperties(student, StudentResponse.class))
                .collect(Collectors.toList());

        return new PageResult<>(
                resultPage.getTotal(),
                resultPage.getCurrent(),
                resultPage.getSize(),
                list
        );
    }
}
