package net.weg.api_gerenciamento_transporte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api_gerenciamento_transporte.controller.response.EnderecoResponseDTO;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false, unique = true)
    private Integer numero;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String bairro;
    private String cep;

    public EnderecoResponseDTO toDto() {
        return new EnderecoResponseDTO(this.rua, this.numero, this.cidade, this.estado, this.bairro);
    }
}
