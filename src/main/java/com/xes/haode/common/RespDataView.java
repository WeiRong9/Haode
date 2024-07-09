//package com.xes.haode.common.result;
//
//import com.dahai.video.common.enums.CommonRespCode;
//import com.dahai.video.common.exception.BusinessException;
//import com.dahai.video.dubbotrace.TraceIdUtil;
//import com.google.common.base.Objects;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//
//import java.io.Serializable;
//import java.util.function.Supplier;
//
///**
// * <p>控制器返回数据结构</p>
// *
// * @author gairuyi
// */
//@Data
//@ApiModel(description = "公共返回对象")
//public class RespDataView<T> implements Serializable {
//
//    public static final int RESPONSE_OK = 200;
//    private static final String RESPONSE_OK_MESSAGE = "OK";
//
//    @ApiModelProperty(value = "返回状态码", notes = "除了 200 都是失败")
//    private Integer statusCode;
//    @ApiModelProperty(value = "返回语句", notes = "失败原因或者其他提示")
//    private String statusText;
//    @ApiModelProperty(value = "返回实体类")
//    private T data;
//    private String requestId;
//    private Long responseTs;
//    private Long requestTs;
//    private Long costTime;
//    private String token;
//
//    /**
//     * 正常结果
//     *
//     * @param t   要返回的对象
//     * @param <T> 要返回的对象类型
//     * @return
//     */
//    public static <T> RespDataView<T> ok(T t) {
//        RespDataView<T> respDataView = new RespDataView<>();
//        respDataView.setData(t);
//        respDataView.setRequestId(TraceIdUtil.traceId());
//        respDataView.setStatusCode(CommonRespCode.SUCCESS.getCode());
//        respDataView.setStatusText(CommonRespCode.SUCCESS.getMessage());
//        return respDataView;
//    }
//
//    /**
//     * 正常结果
//     *
//     * @param <T> 要返回的对象类型
//     * @return
//     */
//    public static <T> RespDataView<T> ok() {
//        RespDataView<T> respDataView = new RespDataView<>();
//        respDataView.setData(null);
//        respDataView.setRequestId(TraceIdUtil.traceId());
//        respDataView.setStatusCode(CommonRespCode.SUCCESS.getCode());
//        respDataView.setStatusText(CommonRespCode.SUCCESS.getMessage());
//        return respDataView;
//    }
//
//    /**
//     * 异常结果
//     *
//     * @param e 业务异常
//     * @return
//     */
//    public static <T> RespDataView<T> businessError(BusinessException e) {
//        RespDataView<T> respDataView = new RespDataView<>();
//        respDataView.setRequestId(TraceIdUtil.traceId());
//        if (e.getCode() == null) {
//            respDataView.setStatusCode(CommonRespCode.SERVER_ERROR.getCode());
//        } else {
//            respDataView.setStatusCode(e.getCode());
//        }
//        respDataView.setStatusText(e.getMessage());
//        return respDataView;
//    }
//
//    /**
//     * 服务器错误
//     *
//     * @return
//     */
//    public static RespDataView serverError() {
//        RespDataView respDataView = new RespDataView<>();
//        respDataView.setRequestId(TraceIdUtil.traceId());
//        respDataView.setStatusCode(CommonRespCode.SERVER_ERROR.getCode());
//        respDataView.setStatusText(CommonRespCode.SERVER_ERROR.getMessage());
//        return respDataView;
//    }
//
//    /**
//     * 通用错误
//     * @param commonRespCode
//     * @return
//     */
//    public static RespDataView error(CommonRespCode commonRespCode) {
//
//        RespDataView respDataView = new RespDataView<>();
//        respDataView.setRequestId(TraceIdUtil.traceId());
//        respDataView.setStatusCode(commonRespCode.getCode());
//        respDataView.setStatusText(commonRespCode.getMessage());
//        return respDataView;
//    }
//
//    public static RespDataView errorByMessage(Integer statusCode, String message){
//        RespDataView respDataView = new RespDataView<>();
//        respDataView.setRequestId(TraceIdUtil.traceId());
//        respDataView.setStatusCode(statusCode);
//        respDataView.setStatusText(message);
//        return respDataView;
//    }
//
//
//
//    public Boolean isSuccess(){
//        return Objects.equal(this.getStatusCode(),RESPONSE_OK);
//    }
//
//    /**
//     * 获取不为空的范型数据
//     * @NullPointerException 状态判断成功,但获取的数据为空
//     * @BusinessException 状态判断不成功,业务异常
//     * @return
//     */
//    public T nonNullData() {
//        return this.nonNullData(() -> BusinessException.build(CommonRespCode.NO_DATA_EXIST));
//    }
//
//    /**
//     * 获取不为空的范型数据,如果为空抛出supplier.get()
//     * @param supplier
//     * @return
//     */
//    public T nonNullData(Supplier<BusinessException> supplier){
//        if (this.isSuccess()) {
//            if (this.getData() != null) {
//                return this.getData();
//            }
//            BusinessException e = supplier.get();
//            throw e;
//        }
//        throw new BusinessException(this.getStatusCode(), this.getStatusText());
//    }
//}
