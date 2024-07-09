package com.xes.haode.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 角色表
 *
 * @author wr
 * @date 2024/07/01
 */
@Data
@TableName("role")
public class RoleVO implements Serializable {
    @TableId
    private Long id;
    private String roleName;
    private String roleDescribe;
    private String creator;
    private Date create;
    private String status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime; // 更新时间

    @TableLogic
    private Integer deleted; // 删除标志 (0: 未删除, 1: 已删除)
}
