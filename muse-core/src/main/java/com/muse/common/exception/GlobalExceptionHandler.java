package com.muse.common.exception;

import com.muse.common.model.Result;
import com.muse.common.model.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/24
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = MuseException.class)
    public Object errorHandler(HttpServletRequest request, MuseException e) {
        // 登录异常
//        if (e instanceof AuthenticationException) {
//            return new Result<>(ResultCode.USER_NOT_LOGGED_IN);
//        }

        // 自定义异常
        if (e instanceof MuseException) {
            return Result.FAIL(e.getMessage());
        }

        // 错误的请求||参数类型不对||参数输入不全
//        if (e instanceof HttpRequestMethodNotSupportedException ||
//            e instanceof TypeMismatchException ||
//            e instanceof MissingServletRequestParameterException) {
//            return new Result<>(ResultCode.INVALID_PARAM);
//        }

        return Result.FAIL();
    }
}
