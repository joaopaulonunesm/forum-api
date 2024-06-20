package com.forum.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodigoErro {

    ERRO_GENERICO("forum.erro.erro-generico"),
    ERRO_TOPICO_NAO_EXISTENTE("forum.erro.topico-nao-existente"),
    ERRO_USUARIO_EXISTENTE("forum.erro.usuario-existente");

    private String codigo;

}
