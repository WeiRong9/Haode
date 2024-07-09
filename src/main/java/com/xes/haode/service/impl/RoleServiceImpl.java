package com.xes.haode.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xes.haode.entity.dto.RoleDTO;
import com.xes.haode.entity.vo.RoleVO;
import com.xes.haode.mapper.RoleMapper;
import com.xes.haode.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleVO> implements RoleService {
    @Override
    public List<RoleVO> getRoles(RoleDTO roleDTO) {
        LambdaQueryWrapper<RoleVO> lqw=new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(roleDTO.getRoleName())){
            lqw.eq(RoleVO::getRoleName,roleDTO.getRoleName());
        }
        if(StrUtil.isNotBlank(roleDTO.getStatus())){
            lqw.eq(RoleVO::getStatus,roleDTO.getStatus());
        }
        return this.baseMapper.selectList(lqw);
    }

    @Override
    public Integer addRole(RoleDTO roleDTO) {
        RoleVO roleVO = BeanUtil.copyProperties(roleDTO, RoleVO.class);
        return this.baseMapper.insert(roleVO);
    }

    @Override
    public Integer deleteRole(RoleDTO roleDTO) {
        return this.baseMapper.deleteById(roleDTO.getId());
    }

    @Override
    public Integer updateRole(RoleDTO roleDTO) {
        RoleVO roleVO = BeanUtil.copyProperties(roleDTO, RoleVO.class);
        return this.baseMapper.updateById(roleVO);
    }
}
