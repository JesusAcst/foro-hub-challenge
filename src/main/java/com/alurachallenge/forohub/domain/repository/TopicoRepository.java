package com.alurachallenge.forohub.domain.repository;

import com.alurachallenge.forohub.domain.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
