package com.xes.haode.service;

import com.xes.haode.entity.dto.RoleDTO;
import com.xes.haode.entity.dto.UserDTO;
import com.xes.haode.entity.vo.RoleVO;

import java.util.List;

public interface RoleService {
    List<RoleVO> getRoles(RoleDTO roleDTO);
    Integer addRole(RoleDTO roleDTO);
    Integer deleteRole(RoleDTO roleDTO);
    Integer updateRole(RoleDTO roleDTO);
}
