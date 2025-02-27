package net.weg.api_gerenciamento_transporte.controller.response;

import net.weg.api_gerenciamento_transporte.model.Endereco;
import net.weg.api_gerenciamento_transporte.model.Rota;

public record RotaResponseDTO(
    Endereco origem,
    Endereco destino
) {
    public Rota toEntity() {
        return Rota.builder()
            .origem(this.origem)
            .destino(this.destino)
            .build();
    }
}
