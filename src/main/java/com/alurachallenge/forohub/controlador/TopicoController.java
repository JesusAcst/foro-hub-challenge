package com.alurachallenge.forohub.controlador;

import com.alurachallenge.forohub.domain.modelo.Topico;
import com.alurachallenge.forohub.domain.modelo.TopicoDTO;
import com.alurachallenge.forohub.domain.servicio.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@Valid @RequestBody TopicoDTO topicoDTO) {
        Topico topico = new Topico();
        topico.setTitulo(topicoDTO.getTitulo());
        topico.setMensaje(topicoDTO.getMensaje());
        topico.setEstado(topicoDTO.getEstado());
        topico.setAutor(topicoDTO.getAutor());
        topico.setCurso(topicoDTO.getCurso());
        topico.setFechaCreacion(LocalDateTime.now()); // Configura la fecha actual

        Topico nuevoTopico = topicoService.crearTopico(topico);
        return ResponseEntity.ok(nuevoTopico);
    }


    @GetMapping
    public ResponseEntity<List<Topico>> obtenerTodos() {
        return ResponseEntity.ok(topicoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerPorId(@PathVariable Long id) {
        return topicoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico datosActualizados) {
        try {
            Topico topicoActualizado = topicoService.actualizarTopico(id, datosActualizados);
            return ResponseEntity.ok(topicoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        try {
            topicoService.eliminarTopico(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


