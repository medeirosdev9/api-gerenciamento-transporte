package net.weg.api_gerenciamento_transporte.controller.request;

import net.weg.api_gerenciamento_transporte.model.Endereco;
import net.weg.api_gerenciamento_transporte.model.Rota;

public record RotaRequestDTO(
    Endereco origemId,
    Endereco destinoId
) {
    public Rota toEntity() {
        return Rota.builder()
            .origem(this.origemId)
            .destino(this.destinoId)
            .build();
    }
}
