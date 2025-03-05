package net.weg.api_gerenciamento_transporte.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.api_gerenciamento_transporte.model.Motorista;
import net.weg.api_gerenciamento_transporte.model.Veiculo;

public record VeiculoRequestDTO(
        @NotBlank String marca,
        @NotBlank String modelo,
        @NotBlank String placa,
        @NotNull Long motoristaId
) {
    public Veiculo toEntity(Motorista motorista) {
        return Veiculo.builder()
                .marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .motorista(motorista)
                .build();
    }
}
