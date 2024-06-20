package com.forum.services;

import com.forum.controllers.models.TopicoResponse;
import com.forum.repositories.TopicoRepository;
import com.forum.repositories.entities.TopicoEntity;
import com.forum.controllers.models.TopicoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public void publicar(TopicoRequest topicoRequest) {
        topicoRepository.save(toEntity(topicoRequest));
    }

    public List<TopicoResponse> buscarTodos() {
        return topicoRepository.findAll().stream()
                .map(TopicoService::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<TopicoResponse> buscarPorIdResponse(UUID idTopico) {
        return buscarPorId(idTopico).map(TopicoService::toResponse);
    }

    public Optional<TopicoEntity> buscarPorId(UUID idTopico) {
        return topicoRepository.findById(idTopico);
    }

    private TopicoEntity toEntity(TopicoRequest topicoRequest) {
        return TopicoEntity.builder()
                .titulo(topicoRequest.titulo())
                .conteudo(topicoRequest.conteudo())
                .build();
    }

    private static TopicoResponse toResponse(TopicoEntity topicoEntity) {
        return new TopicoResponse(topicoEntity.getId(),topicoEntity.getTitulo(),topicoEntity.getConteudo());
    }
}
