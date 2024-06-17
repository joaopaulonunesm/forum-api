package com.forum.services;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private String codigo;

    public ServiceException(CodigoErro codigo) {
        super(codigo.getCodigo());
        this.codigo = codigo.getCodigo();
    }
}
