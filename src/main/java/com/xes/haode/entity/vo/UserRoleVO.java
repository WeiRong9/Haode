package com.xes.haode.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户角色表
 *
 * @author wr
 * @date 2024/07/09
 */
@Data
@TableName("user_role")
public class UserRoleVO implements Serializable {
    private Long userId;
    private Long roleId;
    private String roleName;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime; // 更新时间

    @TableLogic
    private Integer deleted; // 删除标志 (0: 未删除, 1: 已删除)
}
