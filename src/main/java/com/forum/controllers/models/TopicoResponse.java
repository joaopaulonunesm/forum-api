package com.forum.controllers.models;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TopicoResponse {
    private UUID id;
    private String titulo;
    private String conteudo;
}
