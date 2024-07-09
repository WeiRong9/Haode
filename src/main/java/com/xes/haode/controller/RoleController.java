package com.xes.haode.controller;

import com.xes.haode.common.ResultData;
import com.xes.haode.entity.dto.RoleDTO;
import com.xes.haode.entity.dto.UserDTO;
import com.xes.haode.entity.vo.RoleVO;
import com.xes.haode.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(tags = "角色Controller")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/find")
    @ApiOperation(value = "查询角色")
    public ResultData<List<RoleVO>> getRoles(RoleDTO roleDTO){
        return ResultData.ok(roleService.getRoles(roleDTO));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加角色")
    public ResultData<Integer> addRole(@RequestBody RoleDTO roleDTO){
        return ResultData.ok(roleService.addRole(roleDTO));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除角色")
    public ResultData<Integer> deleteRole(@RequestBody RoleDTO roleDTO){
        return ResultData.ok(roleService.deleteRole(roleDTO));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新角色")
    public ResultData<Integer> updateRole(@RequestBody RoleDTO roleDTO){
        return ResultData.ok(roleService.updateRole(roleDTO));
    }
}
