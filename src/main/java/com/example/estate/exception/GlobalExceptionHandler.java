package com.example.estate.exception;

import com.example.estate.common.MessageConstant;
import com.example.estate.common.Result;
import com.example.estate.common.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auth: dyq
 * @Desc: 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 功能描述: 捕获Exception类型的异常，并进行友好错误提示
     *
     * @param exception
     * @return : com.example.estate.common.common.Result
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception exception) {
        exception.printStackTrace();
        return new Result(false, StatusCode.ERROR, MessageConstant.SYSTEM_BUSY);
    }
}
