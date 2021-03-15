package com.todoapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 */
@Controller
@ResponseBody
public class GeneralErrorController implements ErrorController {

    private static Logger LOGGER = LogManager.getLogger(GeneralErrorController.class);
    private String htmlExceptionMsg = "<html>"
            + "<body>"
            + "<div>Exception: <b>%s</b></div>"
            + "<a href='/'>Main Page</a>"
            + "<body>"
            + "</html>";

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {

        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

        return String.format(htmlExceptionMsg, exception != null ? exception.getMessage() : "Page cannot load...");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
