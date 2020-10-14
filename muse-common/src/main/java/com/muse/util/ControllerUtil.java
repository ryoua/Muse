package com.muse.util;


import com.muse.model.Result;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/12
 **/
public class ControllerUtil {
    public static Result checkResult(int result) {
        if (result == 1) {
            return Result.SUCCESS();
        } else {
            return Result.FAIL();
        }
    }
}
