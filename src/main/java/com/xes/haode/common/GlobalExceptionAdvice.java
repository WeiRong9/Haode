//package com.xes.haode.common;
//
//import com.dahai.video.business.utils.GlobalAlarmUtils;
//import com.dahai.video.common.core.feign.FeignClientException;
//import com.dahai.video.common.enums.CommonRespCode;
//import com.dahai.video.common.exception.BusinessException;
//import com.dahai.video.common.result.RespDataView;
//import com.dahai.video.common.utils.LogJsonHelper;
//import com.dahai.video.common.utils.UserTokenConstants;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindException;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.ConstraintViolationException;
//import java.util.List;
//
///**
// * <p>全局异常拦截器</p>
// *
// * @author gairuyi
// */
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionAdvice {
//    private static Logger ERROR_LOG = LoggerFactory.getLogger("api");
//
//    @Autowired
//    private GlobalAlarmUtils globalAlarmUtils;
//
//    /**
//     * ß
//     * 服务异常
//     *
//     * @param request
//     * @param e
//     * @return
//     * @throws Exception
//     */
//    @ExceptionHandler(Exception.class)
//    public RespDataView handException(HttpServletRequest request, Exception e) throws Exception {
//        Long requestTime = request.getAttribute(UserTokenConstants.REQUEST_TS_KEY) == null ?
//                System.currentTimeMillis() : (Long) request.getAttribute(UserTokenConstants.REQUEST_TS_KEY);
//        String userLid = request.getAttribute(UserTokenConstants.CURRENT_REQUEST_USER_KEY) != null ?
//                (String) request.getAttribute(UserTokenConstants.CURRENT_REQUEST_USER_KEY) : "";
//        String requestURI = request.getRequestURI();
//        String method = request.getMethod();
//        String msg = method.concat("-").concat(requestURI);
//        RespDataView err = null;
//        if (e instanceof BusinessException) {
//            //打印错误日志
//            err = RespDataView.businessError((BusinessException) e);
//        } else {
//            err = RespDataView.serverError();
//        }
//        err.setRequestTs(requestTime);
//        err.setResponseTs(System.currentTimeMillis());
//        err.setCostTime(System.currentTimeMillis() - requestTime);
//        //打印错误日志
//        log.error("handException:{},{}", userLid, e.getMessage(), e);
//        globalAlarmUtils.alarm(request, e);
//        return err;
//    }
//
//    /**
//     * post body参数校验异常
//     * @author hanqingsong
//     * @date 2021-01-13
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public RespDataView handMethodArgumentNotValidException(HttpServletRequest request,
//                                                            MethodArgumentNotValidException e) throws Exception {
//        List<ObjectError> errors = e.getBindingResult().getAllErrors();
//        StringBuilder errmsg = new StringBuilder();
//        errors.forEach((error -> errmsg.append(error.getDefaultMessage()).append(";")));
//        log.error("异常处理,{},{}", errmsg, e.getMessage());
//        globalAlarmUtils.alarm(request, e);
//        return RespDataView.errorByMessage(CommonRespCode.REQ_PARAMS_ERROR.getCode(), errmsg.toString());
//    }
//    /**
//     * get参数校验，缺少参数字段
//     * @author hanqingsong
//     * @date 2021-01-13
//     */
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public RespDataView handMissingServletRequestParameterException(HttpServletRequest request,
//                                                                    MissingServletRequestParameterException e) {
//        String message = e.getParameterName() + "不能为空。";
//        log.error("异常处理,{},{}", message, e.getMessage());
//        globalAlarmUtils.alarm(request, e);
//        return RespDataView.errorByMessage(CommonRespCode.REQ_PARAMS_ERROR.getCode(), message);
//    }
//    /**
//     * get参数校验，缺少参数值
//     * @author hanqingsong
//     * @date 2021-01-13
//     */
//    @ExceptionHandler({ConstraintViolationException.class})
//    public RespDataView handleConstraintViolationException(HttpServletRequest request,
//                                                             ConstraintViolationException e) {
//        String message = e.getMessage();
//        log.error("异常处理,{}", message);
//        globalAlarmUtils.alarm(request, e);
//        return RespDataView.errorByMessage(CommonRespCode.REQ_PARAMS_ERROR.getCode(), message);
//    }
//    /**
//     * ß
//     * 服务异常
//     *
//     * @param request
//     * @param e
//     * @return
//     * @throws Exception
//     */
//    @ExceptionHandler(BindException.class)
//    public RespDataView handParamException(HttpServletRequest request, BindException e) throws Exception {
//        Long requestTime = request.getAttribute(UserTokenConstants.REQUEST_TS_KEY) == null ?
//                System.currentTimeMillis() : (Long) request.getAttribute(UserTokenConstants.REQUEST_TS_KEY);
//        String userLid = request.getAttribute(UserTokenConstants.CURRENT_REQUEST_USER_KEY) != null ?
//                (String) request.getAttribute(UserTokenConstants.CURRENT_REQUEST_USER_KEY) : "";
//        String requestURI = request.getRequestURI();
//        String method = request.getMethod();
//        String msg = method.concat("-").concat(requestURI);
//        RespDataView err = new RespDataView();
//        StringBuilder stringBuilder = new StringBuilder();
//        e.getAllErrors().forEach(x -> stringBuilder.append(x.getDefaultMessage()).append(";"));
//        err.setRequestTs(requestTime);
//        err.setResponseTs(System.currentTimeMillis());
////        err.setRequestId(TraceIdUtil.traceId());
//        err.setStatusCode(CommonRespCode.REQ_PARAMS_ERROR.getCode());
//        err.setData(stringBuilder.toString());
//        err.setStatusText(CommonRespCode.REQ_PARAMS_ERROR.getMessage());
//        err.setCostTime(System.currentTimeMillis() - requestTime);
//        //打印错误日志
//        log.error("{} | {}", userLid, LogJsonHelper.getExceptionLog(request, requestURI, method, request.getParameterMap(), e));
//        globalAlarmUtils.alarm(request, e);
//        return err;
//    }
//    @ExceptionHandler(BusinessException.class)
//    public RespDataView handBusinessException(HttpServletRequest request, BusinessException e) throws Exception {
//
//        e.printStackTrace();
//        String requestURI = request.getRequestURI();
//        String method = request.getMethod();
//        //打印错误日志
//        log.info("handBusinessException:{},{}", LogJsonHelper.getExceptionLog(request, requestURI, method, request.getParameterMap(), e), e);
//        // globalAlarmUtils.alarm(request, e);
//        return RespDataView.businessError(e);
//    }
//
//    @ExceptionHandler(FeignClientException.class)
//    public RespDataView handFeignClientException(HttpServletRequest request, FeignClientException e) throws Exception {
//        String requestURI = request.getRequestURI();
//        String method = request.getMethod();
//        //打印错误日志
//        log.info("handFeignClientException:{},{}", LogJsonHelper.getExceptionLog(request, requestURI, method, request.getParameterMap(), e), e);
//        globalAlarmUtils.alarm(request, "调用其他系统接口失败：" + e.toJSONString(), e);
//        return RespDataView.errorByMessage(505, "调用其他系统接口失败：" + e.toJSONString());
//    }
//}
