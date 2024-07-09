package com.xes.haode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xes.haode.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wr
 * @date 2024/07/01
 */
@Mapper
public interface UserMapper extends BaseMapper<UserVO> {
}
