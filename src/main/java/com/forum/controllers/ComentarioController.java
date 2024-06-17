package com.forum.controllers;

import com.forum.controllers.models.ComentarioRequest;
import com.forum.controllers.models.ComentarioResponse;
import com.forum.controllers.models.Response;
import com.forum.services.ComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comentarios")
@RequiredArgsConstructor
@CrossOrigin
public class ComentarioController {

    private final ComentarioService comentarioService;

    @PostMapping("/{idTopico}")
    public ResponseEntity<Void> comentar(@PathVariable("idTopico") UUID idTopico, @RequestBody ComentarioRequest comentarioRequest) {
        comentarioService.comentar(idTopico, comentarioRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idTopico}")
    public ResponseEntity<Response<List<ComentarioResponse>>> buscarComentarioPorTopico(@PathVariable("idTopico") UUID idTopico) {
        return ResponseEntity.ok(new Response(comentarioService.buscarPorTopico(idTopico)));
    }
}
