package net.weg.api_gerenciamento_transporte.controller.request;

import jakarta.validation.constraints.NotBlank;
import net.weg.api_gerenciamento_transporte.model.Motorista;

public record MotoristaRequestDTO(
    @NotBlank String nome,
    @NotBlank String email,
    EnderecoRequestDTO endereco
) {

    public Motorista toEntity() {
        return Motorista.builder()
            .nome(this.nome)
            .email(this.email)
            .endereco(this.endereco.toEntity())
            .build();
    }
}
