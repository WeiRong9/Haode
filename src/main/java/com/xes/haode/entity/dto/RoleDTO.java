package com.xes.haode.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wr
 * @date 2024/07/09
 */
@Data
public class RoleDTO implements Serializable {
    private Long id;
    private String roleName;
    private String roleDescribe;
    private String creator;
    private Date create;
    private String status;
}
