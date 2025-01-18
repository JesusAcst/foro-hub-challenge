package com.alurachallenge.forohub.domain.modelo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoDTO {
    @NotNull
    private String titulo;

    @NotNull
    private String mensaje;

    @NotNull
    private String estado;

    @NotNull
    private String autor;

    @NotNull
    private String curso;

}

