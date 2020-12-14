package com.zsp.comic.util;

import com.zsp.comic.entity.JsonResult;
import com.zsp.comic.entity.ResultCode;

/**
 * @author gan
 * @create 2020-12-03 22:42
 */
public class ResultTool {
    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }
}
