package net.weg.api_gerenciamento_transporte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api_gerenciamento_transporte.controller.response.MotoristaResponseDTO;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "motorista")
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToOne
    @JoinColumn(name = "endereco_id", unique = true, nullable = false)
    private Endereco endereco;
    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rota> rotas;

    public MotoristaResponseDTO toDto() {
        return new MotoristaResponseDTO(this.id, this.nome, this.email, this.endereco.toDto());
    }

}
