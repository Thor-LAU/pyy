package com.pyyexclusivenew.pyy.util.code;

/*
 * @Author ThorLau
 * @CreateTime 2021/8/31 17:07
 * @Desc CodeEnum
 */
public enum CodeEnum {
    ALL_SUCCESS(
            0x00101001, "成功"),
    ALL_INTERNAL(
            0x00101002, "操作失败"),
    IS_NULL(
            0x00101003, "参数不能为空"),
    IS_EXIST(
            0x00101004, "描述信息已存在"),
    NOT_EXIST(
            0x00101005, "用户信息不存在"),
    MORE_EXIST(
            0x00101006, "用户信息重复存在，请删除多余重复用户"),
    PASSWD_ERROR(
            0x00101007, "密码错误，请重新输入"),
    USER_NAME_IS_NULL(
            0x00101008, "用户名不能为空"),
    USER_PASSWD_IS_NULL(
            0x00101009, "密码不能为空"),
    ;
    private int code;
    private String desc;

    CodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "CodeEnum{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
