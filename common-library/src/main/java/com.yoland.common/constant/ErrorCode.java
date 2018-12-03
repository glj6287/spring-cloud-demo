package com.yoland.common.constant;

/**
 * 错误代码枚举
 * @author leo
 * @since 2018/7/27 8:49
 */
public enum ErrorCode {

    /**
     * BASE Code
     */
    SUCCESS("000000","操作成功"),
    SYSTEM_ERROR("BASE_000000", "系统运行异常！"),
    PARAM_IS_NULL("BASE_000001", "请求参数为空！"),
    PARAM_ERROR("BASE_000002", "输入参数有误！"),
    PARAM_MUST("BASE_000003", "必须参数不能为空！"),
    PARAM_INTERFACE("BASE_000004", "请求接口有误"),
    LIMITED_AUTHORITY("BASE_000005", "您没有此权限操作"),

    /**
     * DB COMMON Code
     */
    ID_EMPTY("COMMON_000000", "ID不能为空"),
    VALID_EMPTY("COMMON_000001", "是否不能为空"),
    PAGE_ERROR("COMMON_000002", "分页查询异常"),
    SAVE_ERROR("COMMON_000003", "保存数据异常"),
    UPDATE_ERROR("COMMON_000004", "更新数据异常"),
    DELETE_ERROR("COMMON_000008", "更新数据异常"),
    SELECT_ERROR("COMMON_000005", "查询数据异常"),
    VERSION_ERROR("COMMON_000006", "版本号不能为空"),
    OPERATE_ERROR("COMMON_000007", "操作失败"),

    /**
     * JSON格式错误
     */
    JSON_ILEEGAL_FORMAT("json_illegal_format", "JSON格式错误，请检查请求参数的格式是否符合标准的JSOn格式"),

    /**
     * token不存在
     */
    JWT_NOT_EXIST("jwt_not_exist", "token不存在"),
    /**
     * 不是合法的jwt token
     */
    JWT_ILLEGAL_TOKEN("jwt_illegal_token", "非法的token"),
    /**
     * Jwt token超时
     */
    JWT_TOKEN_EXPIRED("jwt_token_expired", "token超时"),

    /**
     * 非法参数
     */
    EXCEPTION_ILLEGAL_ARGUMENT("illegal_argument", "非法参数"),

    /**
     * 非法状态
     */
    EXCEPTION_ILLEGAL_STATE("illegal_state", "非法状态"),

    /**
     * 用户不存在
     */
    USER_NOT_EXIST("user_not_exist", "用户不存在"),

    /**
     * 用户被禁止登陆
     */
    USER_NOT_ENABLE("user_not_enable", "用户被禁止登陆，请联系管理员"),

    /**
     * 用户没有分配角色
     */
    USER_NOT_HAVE_ROLE("user_not_have_role", "用户没有分配角色，请联系管理员"),

    /**
     * 用户认证失败
     */
    USER_AUTH_FAILED("user_auth_failed", "用户名或密码错误"),
    USER_PWD_FAILED("user_pwd_failed", "旧密码错误"),

    /**
     * 更新操作失败
     */
    CRUD_UPDATE_NO_RECORD("update_no_record", "更新操作失败"),

    /**
     * 确认密码不一致
     */
    USER_CONFIRM_PASSWORD_FAIL("user_confirm_password_fail", "两次输入密码不一致"),

    /**
     * 用户名已存在
     */
    USER_DUPLICATE_LOGIN_NAME("user_duplicate_login_name", "用户名已存在"),

    /**
     * 组织不存在
     */
    ORG_NOT_EXIST("org_not_exist", "组织不存在"),

    /**
     * 部门不存在
     */
    DEPT_NOT_EXIST("dept_not_exist", "部门不存在"),

    /**
     * 用户权限不足
     */
    USER_LACK_OF_RIGHT("user_lack_of_right", "用户权限不足"),

    /**
     * 请求数据不存在
     */
    SYS_NOT_EXIST("sys_not_exist", "请求数据不存在"),

    /**
     * 没有操作权限
     */
    SYS_NOT_ROLE("sys_not_role", "没有操作权限"),

    DATA_ALREADY_EXISTS("data_already_exists","数据已存在");

    private final String code;

    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
