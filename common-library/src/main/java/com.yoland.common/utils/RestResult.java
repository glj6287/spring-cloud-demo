package com.yoland.common.utils;

import com.yoland.common.constant.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leo
 * @since 2018/7/27 8:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RestResult", description = "Rest api请求结果统一封装对象")
public final class RestResult<T> {

    /**
     * 操作成功状态
     */
    public static final String OPT_SUCCESS_STATUS = "000000";

    /**
     * 操作失败状态
     */
    public static final String OPT_ERROR_STATUS = "error";

    /**
     * api执行结果状态：成功:000000 失败: error
     */
    @ApiModelProperty("api执行结果状态：成功:000000 失败: error")
    private String status;

    /**
     * 错误代码
     */
    @ApiModelProperty("错误代码")
    private String errorCode;

    /**
     * 错误信息
     */
    @ApiModelProperty("错误信息")
    private String errorMessage;

    /**
     * 返回结果数据
     */
    @ApiModelProperty("返回结果数据")
    private T resultData;

    @ApiModelProperty("分页返回结果总记录数")
    private long count;

    public static <T> RestResult<T> success(T t) {
        return new RestResult<>(OPT_SUCCESS_STATUS, null, null, t ,0);
    }
    public static <T> RestResult<T> success(T t,long count) {
        return new RestResult<>(OPT_SUCCESS_STATUS, null, null, t ,count);
    }
    public static <T> RestResult<T> fail(String errorCode, String errorMessage) {
        return new RestResult<>(OPT_ERROR_STATUS, errorCode, errorMessage, null ,0);
    }

    public static <T> RestResult<T> fail(ErrorCode errorCode) {
        return fail(errorCode.getCode(), errorCode.getMessage());
    }

    public static <T> RestResult<T> failList(ErrorCode errorCode, T t) {
        return new RestResult<>(errorCode.getCode(), errorCode.getMessage(), null, t ,0);
    }

}
