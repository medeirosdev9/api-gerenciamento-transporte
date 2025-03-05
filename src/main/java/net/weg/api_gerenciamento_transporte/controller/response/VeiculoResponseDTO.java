package net.weg.api_gerenciamento_transporte.controller.response;

public record VeiculoResponseDTO(
        String marca,
        String modelo,
        String placa,

        MotoristaResponseDTO motorista
) {
}
