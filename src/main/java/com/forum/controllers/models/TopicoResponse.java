package com.forum.controllers.models;

import java.util.UUID;

public record TopicoResponse(UUID id, String titulo, String conteudo) {
}
