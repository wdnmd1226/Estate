package com.example.estate.common;

/**
 * @Auth: dyq
 * @Desc: 标准返回码code
 */
public class StatusCode {

    //成功
    public static final int OK = 2000;
    //失败
    public static final int ERROR = 2001;
    //用户名或密码错误
    public static final int LOGINERROR = 2002;
    //权限不足
    public static final int ACCESSERROR = 2003;
    //远程调用失败
    public static final int REMOTEERROR = 2004;
    //重复操作
    public static final int REPERROR = 2005;

}
