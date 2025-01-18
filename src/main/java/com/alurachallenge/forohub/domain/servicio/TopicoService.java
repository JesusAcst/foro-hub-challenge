package com.alurachallenge.forohub.domain.servicio;

import com.alurachallenge.forohub.domain.modelo.Topico;
import com.alurachallenge.forohub.domain.repositorio.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico crearTopico(Topico topico) {
        topico.setFechaCreacion(LocalDateTime.now());
        return topicoRepository.save(topico);
    }

    public List<Topico> obtenerTodos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> obtenerPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico actualizarTopico(Long id, Topico datosActualizados) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(datosActualizados.getTitulo());
            topico.setMensaje(datosActualizados.getMensaje());
            topico.setEstado(datosActualizados.getEstado());
            topico.setAutor(datosActualizados.getAutor());
            topico.setCurso(datosActualizados.getCurso());
            return topicoRepository.save(topico);
        }).orElseThrow(() -> new RuntimeException("Tópico no encontrado."));
    }

    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico no encontrado.");
        }
        topicoRepository.deleteById(id);
    }
}

