package net.weg.api_gerenciamento_transporte.controller.request;

import jakarta.validation.constraints.NotBlank;
import net.weg.api_gerenciamento_transporte.model.Motorista;
import net.weg.api_gerenciamento_transporte.model.Veiculo;

public record VeiculoRequestDTO(
        @NotBlank String marca,
        @NotBlank String modelo,
        @NotBlank String placa
) {

    public Veiculo toEntity() {
        return Veiculo.builder()
                .marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .build();
    }
}
