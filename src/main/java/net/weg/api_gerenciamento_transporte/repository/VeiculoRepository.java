package net.weg.api_gerenciamento_transporte.repository;

import net.weg.api_gerenciamento_transporte.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
