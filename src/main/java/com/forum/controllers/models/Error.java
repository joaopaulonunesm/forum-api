package com.forum.controllers.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Error {
    private String code;
    private String message;
}
