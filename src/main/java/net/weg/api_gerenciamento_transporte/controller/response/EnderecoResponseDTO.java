package net.weg.api_gerenciamento_transporte.controller.response;

public record EnderecoResponseDTO(
    String rua,
    Integer numero,
    String cidade,
    String estado,
    String bairro
) {
}
