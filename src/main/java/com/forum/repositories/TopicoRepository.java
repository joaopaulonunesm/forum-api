package com.forum.repositories;

import com.forum.repositories.entities.TopicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TopicoRepository extends JpaRepository<TopicoEntity, UUID> {
}
