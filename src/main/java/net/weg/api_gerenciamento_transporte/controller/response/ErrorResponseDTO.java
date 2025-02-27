package net.weg.api_gerenciamento_transporte.controller.response;

import java.time.Instant;

public record ErrorResponseDTO(String mensagem, Instant instant) {
}
