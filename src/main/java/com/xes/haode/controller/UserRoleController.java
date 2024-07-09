package com.xes.haode.controller;

import com.xes.haode.common.ResultData;
import com.xes.haode.entity.dto.UserDTO;
import com.xes.haode.entity.dto.UserRoleDTO;
import com.xes.haode.entity.vo.UserRoleVO;
import com.xes.haode.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-role")
@Api(tags = "用户关联角色Controller")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/find")
    @ApiOperation(value = "查询用户关联角色")
    public ResultData<List<UserRoleVO>> getUserRole(UserRoleDTO userRoleDTO){
        return ResultData.ok(userRoleService.getUserRole(userRoleDTO));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加用户关联角色")
    public ResultData<Integer> addUserRole(@RequestBody UserRoleDTO userRoleDTO){
        return ResultData.ok(userRoleService.addUserRole(userRoleDTO));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户关联角色")
    public ResultData<Integer> deleteUserRole(@RequestBody UserRoleDTO userRoleDTO){
        return ResultData.ok(userRoleService.deleteUserRole(userRoleDTO));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用户关联角色")
    public ResultData<Integer> updateUserRole(@RequestBody UserRoleDTO userRoleDTO){
        return ResultData.ok(userRoleService.updateUserRole(userRoleDTO));
    }
}
