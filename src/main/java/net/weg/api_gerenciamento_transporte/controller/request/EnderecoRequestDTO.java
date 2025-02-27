package net.weg.api_gerenciamento_transporte.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.api_gerenciamento_transporte.model.Endereco;

public record EnderecoRequestDTO(

        @NotBlank String cep,
        @NotBlank String rua,
        @NotNull Integer numero,
        @NotBlank String cidade,
        @NotBlank String estado,
        @NotBlank String bairro
) {

    public Endereco toEntity() {
        return Endereco.builder()
                .cep(cep)
                .rua(rua)
                .numero(numero)
                .cidade(cidade)
                .estado(estado)
                .bairro(bairro)
                .build();
    }
}
