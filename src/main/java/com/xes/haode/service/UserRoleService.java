package com.xes.haode.service;

import com.xes.haode.entity.dto.UserDTO;
import com.xes.haode.entity.dto.UserRoleDTO;
import com.xes.haode.entity.vo.UserRoleVO;

import java.util.List;

public interface UserRoleService {
    List<UserRoleVO> getUserRole(UserRoleDTO userRoleDTO);
    Integer addUserRole(UserRoleDTO userRoleDTO);
    Integer deleteUserRole(UserRoleDTO userRoleDTO);
    Integer updateUserRole(UserRoleDTO userRoleDTO);
}
