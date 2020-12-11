package com.muse.exception;

import com.muse.common.model.ResultCode;

import java.text.MessageFormat;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
public class MuseException extends Exception {

    /**
     * 错误代码
     */
    ResultCode resultCode;

    public MuseException() {
        super();
    }


    public MuseException(String message) {
        super(message);
    }

    public MuseException(ResultCode resultCode){
        super(resultCode.message());
        this.resultCode = resultCode;
    }

    public MuseException(ResultCode resultCode, Object... args){
        super(resultCode.message());
        String message = MessageFormat.format(resultCode.message(), args);
        resultCode.setMessage(message);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }

}
