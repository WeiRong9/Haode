package com.xes.haode.common;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常拦截
 *
 * @author wr
 * @date 2024/07/09
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {
     /**
     * ß
     * 服务异常
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    public ResultData handException(HttpServletRequest request, Exception e) throws Exception {
        Long requestTime=System.currentTimeMillis();
        ResultData err = null;
        err.setRequestId(IdUtil.getSnowflake().nextIdStr());
        err.setRequestTs(requestTime);
        err.setResponseTs(System.currentTimeMillis());
        err.setCostTime(System.currentTimeMillis() - requestTime);
        log.error("handException:{},{}", request, e.getMessage(), e);
        return err;
    }
}
