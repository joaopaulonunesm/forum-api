package com.forum.repositories;

import com.forum.repositories.entities.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ComentarioRepository extends JpaRepository<ComentarioEntity, UUID> {
    List<ComentarioEntity> findByTopicoId(UUID idTopico);
}
