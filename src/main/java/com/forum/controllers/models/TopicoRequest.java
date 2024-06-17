package com.forum.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TopicoRequest {
    private String titulo;
    private String conteudo;
}
