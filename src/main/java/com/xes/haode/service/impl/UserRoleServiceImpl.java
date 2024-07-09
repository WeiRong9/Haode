package com.xes.haode.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xes.haode.entity.dto.UserRoleDTO;
import com.xes.haode.entity.vo.UserRoleVO;
import com.xes.haode.mapper.UserRoleMapper;
import com.xes.haode.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleVO> implements UserRoleService {
    @Override
    public List<UserRoleVO> getUserRole(UserRoleDTO userRoleDTO) {
        LambdaQueryWrapper<UserRoleVO> lqw = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(userRoleDTO.getRoleName())) {
            lqw.eq(UserRoleVO::getRoleName, userRoleDTO.getRoleName());
        }
        if (userRoleDTO.getUserId() != null && userRoleDTO.getUserId() != 0) {
            lqw.eq(UserRoleVO::getUserId, userRoleDTO.getUserId());
        }
        if (userRoleDTO.getRoleId() != null && userRoleDTO.getRoleId() != 0) {
            lqw.eq(UserRoleVO::getRoleId, userRoleDTO.getRoleId());
        }
        return this.baseMapper.selectList(lqw);
    }

    @Override
    public Integer addUserRole(UserRoleDTO userRoleDTO) {
        UserRoleVO userRoleVO = BeanUtil.copyProperties(userRoleDTO, UserRoleVO.class);
        return this.baseMapper.insert(userRoleVO);
    }

    @Override
    public Integer deleteUserRole(UserRoleDTO userRoleDTO) {
        Integer mark = 0;
        if (userRoleDTO.getUserId() != null && userRoleDTO.getUserId() != 0 && userRoleDTO.getRoleId() != null && userRoleDTO.getRoleId() != 0) {
            mark = this.baseMapper.delete(new LambdaQueryWrapper<UserRoleVO>().eq(UserRoleVO::getUserId, userRoleDTO.getUserId()).eq(UserRoleVO::getRoleId, userRoleDTO.getRoleId()));
        }
        return mark;
    }

    @Override
    public Integer updateUserRole(UserRoleDTO userRoleDTO) {
        UserRoleVO userRoleVO = BeanUtil.copyProperties(userRoleDTO, UserRoleVO.class);
        return this.baseMapper.updateById(userRoleVO);
    }
}
