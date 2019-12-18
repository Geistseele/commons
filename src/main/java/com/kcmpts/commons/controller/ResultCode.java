package com.kcmpts.commons.controller;

/**
 * @author klauszong
 */

@SuppressWarnings("unused")
public enum ResultCode {
    // 成功请求
    success(200, "操作成功"),
    // 重定向
    redirect(301, "redirect"),
    // 资源未找到
    ex_not_found(404, "not found"),
    // 服务器错误
    ex_server_error(500, "server error"),

    /* 无异常,但业务操作失败：1001-1999 */
    failure(1001, "操作失败"),

    ex_NumberFormatException(90001, "您输入的数字有误，请核对后重试"),
    ex_IndexOutOfBoundsException(90002, "数据位置错误或不存在，请核对后重试"),
    ex_DataIntegrityViolationException(90003,"您提交的数据不完整，请核对后重试"),

//    /* 参数错误：2001-2999 */
//    param_is_invalid(2001, "参数无效"),
//    param_is_blank(2002, "参数为空"),
//    param_type_bind_error(2003, "参数类型错误"),
//    param_not_complete(2004, "参数缺失"),
//    ex_null_point(2011, "空指针异常"),
//    ex_class_cast(2012, "类型转换异常"),
//    ex_id(1003, "类型转换异常"),
//    ex_not_method(2014, "未知方法异常"),
//    ex_arithmetic(2015, "算术运算参数异常，请核对您输入的数值后重试"),
//
//    /* 业务错误：3001-3999 */
//    specified_questioned_user_not_exist(3001, "某业务出现问题"),
//
//    /* 系统错误：4001-4999 */
//    system_inner_error(4001, "系统繁忙，请稍后重试"),
//
//    /* 数据错误：5001-59999 */
//    resule_data_none(5001, "数据未找到"),
//    data_is_wrong(5002, "数据有误"),
//    data_already_existed(5003, "数据已存在"),
//
//    /* 接口错误：6001-6999 */
//    interface_inner_invoke_error(6001, "内部系统接口调用异常"),
//    interface_outter_invoke_error(6002, "外部系统接口调用异常"),
//    interface_forbid_visit(6003, "该接口禁止访问"),
//    interface_address_invalid(6004, "接口地址无效"),
//    interface_request_timeout(6005, "接口请求超时"),
//    interface_exceed_load(6006, "接口负载过高"),

    /* 用户错误：8001-8999*/
//    user_not_logged_in(8001, "用户未登录"),
//    user_login_error(8002, "账号不存在或密码错误"),
//    user_account_forbidden(8003, "账号已被禁用"),
//    user_not_exist(8004, "用户不存在"),
//    user_has_existed(8005, "用户已存在"),
//
//    /* 权限错误：9001-9998 */
//    permission_no_access(9001, "无访问权限"),


    ;

    private Integer code;
    private String msg;


    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ResultCode valueOf(int code) {
        for (ResultCode result : values()) {
            if (code == result.code) {
                return result;
            }
        }
        return success;
    }
}
