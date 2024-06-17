package com.forum.controllers;

import com.forum.controllers.models.Response;
import com.forum.controllers.models.TopicoRequest;
import com.forum.controllers.models.TopicoResponse;
import com.forum.services.TopicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
@CrossOrigin
public class TopicoController {

    private final TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Void> publicar(@RequestBody TopicoRequest topicoRequest) {
        topicoService.publicar(topicoRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Response<List<TopicoResponse>>> buscarTopicos() {
        return ResponseEntity.ok(new Response(topicoService.buscarTodos()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<TopicoResponse>> buscarTopicoPorId(@PathVariable("id") UUID id) {
        Optional<TopicoResponse> topicoResponse = topicoService.buscarPorIdResponse(id);

        if (topicoResponse.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(new Response(topicoResponse));
    }
}
