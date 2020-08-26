package ru.bellintegrator.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.bellintegrator.practice.responsewrappers.FailureWrapper;

@ControllerAdvice
public class ExceptionContoller extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public FailureWrapper handleAccessDeniedException(
            Exception ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        return new FailureWrapper(errorMessage);
    }
}
