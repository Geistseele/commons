package com.kcmpts.commons.controller;

import com.kcmpts.commons.Const;
import lombok.Data;

import java.io.Serializable;

/**
 * @author klauszong
 */
@SuppressWarnings("unused")
@Data
public class ApiResult<T> implements Serializable {

    /**
     * 操作结果
     */
    private String result;
    /**
     * 返回状态码（自定义状态码，非http状态码）
     */
    private Integer code;
    /**
     * 返回对象
     */
    private T bizData;
    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回自定义结果
     *
     * @param opResult 标识字符串
     * @param msg 自定义状态码
     */
    public ApiResult(String opResult, String msg) {
        this.msg = msg;
        this.result = opResult;
    }


    /**
     * 构造成功
     */
    public ApiResult() {
        this.code = 200;
        this.msg = "操作成功";
        this.result = Const.OP_SUCCESS;
    }

    /**
     * 构造成功
     *
     * @param obj 数据对象
     */
    public ApiResult(T obj) {
        this.code = 200;
        this.bizData = obj;
        this.result = Const.OP_SUCCESS;
    }


    /**
     * 构造 失败
     *
     * @param code 自定义业务失败状态码
     */
    public ApiResult(Integer code) {
        this.result = Const.OP_FAILURE;
        this.code = code;
    }

    /**
     * 构造 失败
     *
     * @param resultCode 业务失败状态码
     */
    public ApiResult(ResultCode resultCode) {
        this.result = Const.OP_FAILURE;
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    /**
     * 返回自定义结果
     *
     * @param opResult 结果描述字符串
     * @param msg 自定义错误消息
     * @param <T>  泛型
     * @return ApiResult
     */
    public static <T> ApiResult<T> common(String opResult, String msg) {
        return new ApiResult<T>(opResult, msg);
    }

    /**
     * 返回成功
     *
     * @param bizData 带数据，如：pageinfo
     * @param <T>     泛型
     * @return ApiResult
     */
    public static <T> ApiResult<T> success(T bizData) {
        return new ApiResult<T>(bizData);
    }

    /**
     * 返回成功 不带数据
     *
     * @param <T> 泛型
     * @return ApiResult
     */
    public static <T> ApiResult<T> success() {
        return new ApiResult();
    }

    /**
     * 返回失败
     *
     * @param code 自定义状态码
     * @param <T>  泛型
     * @return ApiResult
     */
    public static <T> ApiResult<T> failure(int code) {
        return new ApiResult<T>(code);
    }

    /**
     * 返回失败
     *
     * @param resultCode 状态码枚举
     * @param <T>        泛型
     * @return ApiResult
     */
    public static <T> ApiResult<T> failure(ResultCode resultCode) {
        return new ApiResult<T>(resultCode);
    }
}
