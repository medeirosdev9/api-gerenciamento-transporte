package net.weg.api_gerenciamento_transporte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api_gerenciamento_transporte.controller.response.VeiculoResponseDTO;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false, unique = true)
    private String placa;
    @OneToOne
    @JoinColumn(name = "motorista_id", unique = true, nullable = false)
    private Motorista motorista;

    public VeiculoResponseDTO toDto() {
        return new VeiculoResponseDTO(this.marca, this.modelo, this.placa,this.motorista.toDto());
    }
}
