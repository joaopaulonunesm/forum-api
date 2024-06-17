package com.forum.controllers.models;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ComentarioResponse {

    private UUID id;
    private String texto;
}
