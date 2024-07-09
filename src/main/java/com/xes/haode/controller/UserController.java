package com.xes.haode.controller;

import com.xes.haode.common.ResultData;
import com.xes.haode.entity.dto.UserDTO;
import com.xes.haode.entity.vo.UserVO;
import com.xes.haode.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户Controller")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/find")
    @ApiOperation(value = "查询用户")
    public ResultData<List<UserVO>> getUsers(UserDTO userDTO){
        return ResultData.ok(userService.getUsers(userDTO));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加用户")
    public ResultData<Integer> addUser(@RequestBody UserDTO userDTO){
        return ResultData.ok(userService.addUser(userDTO));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户")
    public ResultData<Integer> deleteUser(@RequestBody UserDTO userDTO){
        return ResultData.ok(userService.deleteUser(userDTO));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用户")
    public ResultData<Integer> updateUser(@RequestBody UserDTO userDTO){
        return ResultData.ok(userService.updateUser(userDTO));
    }
}
