package com.ty.hh.edu.mapper;

import com.ty.hh.edu.model.entity.StudentsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 学员详细信息表 Mapper 接口
 * </p>
 *
 * @author yufei.cao
 * @since 2025-07-09
 */
public interface StudentsMapper extends BaseMapper<StudentsEntity> {

    StudentsEntity selectByPhone(String phone);

    List<StudentsEntity> listByUserId(Long userId);

}
