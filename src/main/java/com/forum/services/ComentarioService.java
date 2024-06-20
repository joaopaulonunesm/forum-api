package com.forum.services;

import com.forum.controllers.models.ComentarioRequest;
import com.forum.controllers.models.ComentarioResponse;
import com.forum.repositories.ComentarioRepository;
import com.forum.repositories.entities.ComentarioEntity;
import com.forum.repositories.entities.TopicoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final TopicoService topicoService;
    private final ComentarioRepository comentarioRepository;

    public void comentar(UUID idTopico, ComentarioRequest comentarioRequest) {
        TopicoEntity topico = topicoService.buscarPorId(idTopico).orElseThrow(() -> new ServiceException(CodigoErro.ERRO_TOPICO_NAO_EXISTENTE));
        comentarioRepository.save(toEntity(topico, comentarioRequest));
    }

    public List<ComentarioResponse> buscarPorTopico(UUID idTopico) {
        return comentarioRepository.findByTopicoId(idTopico).stream().map(ComentarioService::toDomain).collect(Collectors.toList());
    }

    private ComentarioEntity toEntity(TopicoEntity topico, ComentarioRequest comentarioRequest) {
        return ComentarioEntity.builder()
                .topico(topico)
                .texto(comentarioRequest.texto())
                .build();
    }

    public static ComentarioResponse toDomain(ComentarioEntity comentarioEntity) {
        return new ComentarioResponse(comentarioEntity.getId(), comentarioEntity.getTexto());
    }
}
