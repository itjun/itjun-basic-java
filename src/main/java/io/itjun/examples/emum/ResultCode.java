package io.itjun.examples.emum;

import java.lang.reflect.Method;

public enum ResultCode {
    CODE_5200("8200", "认证失败"),
    CODE_5201("8201", "用户不存在"),
    CODE_5202("8202", "Token验证失败"),
    CODE_5203("8203", "Token刷新失败");
    private String code;
    private String name;

    ResultCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        // 1.得到枚举类对象
        Class<?> clz = ResultCode.class;
        // 2.得到所有枚举常量
        Object[] objects = clz.getEnumConstants();
        Method getCode = clz.getMethod("getCode");
        Method getName = clz.getMethod("getName");
        for (Object obj : objects) {
            // 3.调用对应方法，得到枚举常量中字段的值
            System.out.println("code=" + getCode.invoke(obj) + "; name=" + getName.invoke(obj));
        }
    }

}