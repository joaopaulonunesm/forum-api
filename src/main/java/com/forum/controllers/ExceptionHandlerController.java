package com.forum.controllers;

import com.forum.controllers.models.Error;
import com.forum.controllers.models.Response;
import com.forum.services.CodigoErro;
import com.forum.services.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleServiceException(ServiceException serviceException) {
        String message = messageSource.getMessage(serviceException.getCodigo(), null, LocaleContextHolder.getLocale());
        return Response.builder().errors(List.of(new Error(serviceException.getCodigo(), message))).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Response handleException(Exception serviceException) {
        String message = messageSource.getMessage(CodigoErro.ERRO_GENERICO.getCodigo(), null, LocaleContextHolder.getLocale());
        return Response.builder().errors(List.of(new Error(CodigoErro.ERRO_GENERICO.getCodigo(), message))).build();
    }
}
