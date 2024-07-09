package com.xes.haode.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wr
 * @date 2024/07/09
 */
@Data
public class UserRoleDTO implements Serializable {
    private Long userId;
    private Long roleId;
    private String roleName;
}
