package com.xes.haode.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xes.haode.entity.dto.UserDTO;
import com.xes.haode.entity.vo.UserVO;
import com.xes.haode.mapper.UserMapper;
import com.xes.haode.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserVO> implements UserService {
    @Override
    public List<UserVO> getUsers(UserDTO userDTO) {
        LambdaQueryWrapper<UserVO> lqw = new LambdaQueryWrapper<>();
        if (userDTO.getJobNum() != null && userDTO.getJobNum() != 0) {
            lqw.eq(UserVO::getJobNum, userDTO.getJobNum());
        }
        if(StrUtil.isNotBlank(userDTO.getName())){
            lqw.eq(UserVO::getName,userDTO.getName());
        }
        if(StrUtil.isNotBlank(userDTO.getTeam())){
            lqw.eq(UserVO::getTeam,userDTO.getTeam());
        }
        if(StrUtil.isNotBlank(userDTO.getRoleName())){
            lqw.eq(UserVO::getRoleName,userDTO.getRoleName());
        }
        if(StrUtil.isNotBlank(userDTO.getStatus())){
            lqw.eq(UserVO::getStatus,userDTO.getStatus());
        }
        return this.baseMapper.selectList(lqw);
    }

    @Override
    public Integer addUser(UserDTO userDTO) {
        UserVO userVO = BeanUtil.copyProperties(userDTO, UserVO.class);
        return this.baseMapper.insert(userVO);
    }

    @Override
    public Integer deleteUser(UserDTO userDTO) {
        return this.baseMapper.deleteById(userDTO.getId());
    }

    @Override
    public Integer updateUser(UserDTO userDTO) {
        UserVO userVO = BeanUtil.copyProperties(userDTO, UserVO.class);
        return this.baseMapper.updateById(userVO);
    }
}
