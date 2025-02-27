package net.weg.api_gerenciamento_transporte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api_gerenciamento_transporte.controller.response.RotaResponseDTO;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rota")
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Endereco origem;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Endereco destino;
    private Double distancia;
    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    public RotaResponseDTO toDto() {
        return new RotaResponseDTO(this.origem, this.destino);
    }
}


