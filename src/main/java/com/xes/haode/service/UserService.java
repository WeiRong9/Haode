package com.xes.haode.service;

import com.xes.haode.entity.dto.UserDTO;
import com.xes.haode.entity.vo.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> getUsers(UserDTO userDTO);
    Integer addUser(UserDTO userDTO);
    Integer deleteUser(UserDTO userDTO);
    Integer updateUser(UserDTO userDTO);
}
