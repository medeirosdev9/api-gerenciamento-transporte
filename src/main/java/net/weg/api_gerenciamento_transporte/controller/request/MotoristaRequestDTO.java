package net.weg.api_gerenciamento_transporte.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.api_gerenciamento_transporte.model.Motorista;

public record MotoristaRequestDTO(
        @NotBlank String nome,
        @NotBlank String email,
        @NotNull Long enderecoId
) {
    public Motorista toEntity() {
        return Motorista.builder()
                .nome(this.nome)
                .email(this.email)
                .build();
    }
}
