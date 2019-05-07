package com.jeson.searchroom.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-12 11:26
 *
 * 异常处理类
 **/
@Controller
public class ApiErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiErrorController.class);

    private ErrorAttributes errorAttributes;

    /**
     * 页面异常处理
     * */
    @Override
    public String getErrorPath()
    {
        return ERROR_PATH;
    }

    @Autowired
    public ApiErrorController(ErrorAttributes errorAttributes)
    {
        this.errorAttributes = errorAttributes;
    }

    /**
     * 页面异常处理  定向指定页面
     * */

    @RequestMapping(value = ERROR_PATH ,produces = "text/html")
    public String handleError(HttpServletRequest request, HttpServletResponse response)
    {
        Integer status = (Integer) response.getStatus();
        switch (status){
            case 403 :
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
            default:
                return "index";
        }
    }

    /**
     * 除Web页面外的错误处理，比如Json/XML等
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse errorApiHandler(HttpServletRequest request) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);

        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(requestAttributes, false);
        LOGGER.info(attr.toString());
        int status = getStatus(request);

        return ApiResponse.ofMessage(status, String.valueOf(attr.getOrDefault("message", "error")));
    }

    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }

        return 500;
    }


}
