package com.jeson.searchroom.exception;

import com.jeson.searchroom.base.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-13 15:30
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义异常
     * */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public ApiResponse errorHandler2(BaseException ex) {
        ex.printStackTrace();
        StackTraceElement[] stackTrace = ex.getStackTrace();
        Exception exception = new Exception(ex.getMessage());
        exception.setStackTrace(stackTrace);
        logger.error(ex.fillInStackTrace().toString(), exception);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ex.getCode());
        //todo：根据code获取详细的描述
        switch (apiResponse.getCode()) {
            case 1001: {
                apiResponse.setMessage("data not found.");
            }
            break;
            case 1002: {
                //todo:
            }
            break;
            default:
                apiResponse.setMessage(ex.getMsg());
        }
        return apiResponse;
    }



}
