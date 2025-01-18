package com.alurachallenge.forohub.domain.repositorio;

import com.alurachallenge.forohub.domain.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
