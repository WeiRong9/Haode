package com.xes.haode.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wr
 * @date 2024/07/09
 */
@Data
public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private Long jobNum;
    private String name;
    private String team;
    private String roleName;
    private String creator;
    private Date create;
    private String status;
}
