package com.xes.haode.common;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 公共返回类
 *
 * @author wr
 * @date 2024/07/09
 */
@Data
@ApiModel(description = "公共返回对象")
public class ResultData<T> implements Serializable {
    @ApiModelProperty(value = "返回状态码", notes = "除了 200 都是失败")
    private Integer statusCode;
    @ApiModelProperty(value = "返回语句", notes = "失败原因或者其他提示")
    private String statusText;
    @ApiModelProperty(value = "返回实体类")
    private T data;
    @ApiModelProperty(value = "请求耗时")
    private Long costTime;
    @ApiModelProperty(value = "token授权")
    private String token;
    @ApiModelProperty(value = "请求Id")
    private String requestId;
    private Long requestTs;
    private Long responseTs;

    /**
     * 正常结果
     *
     * @param t   要返回的对象
     * @param <T> 要返回的对象类型
     * @return
     */
    public static <T> ResultData<T> ok(T t) {
        ResultData<T> result = new ResultData<>();
        result.setRequestId(IdUtil.getSnowflake().nextIdStr());
        result.setStatusCode(200);
        result.setStatusText("success");
        result.setData(t);
        return result;
    }
}
