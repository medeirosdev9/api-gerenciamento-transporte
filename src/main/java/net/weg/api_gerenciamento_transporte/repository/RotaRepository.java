package net.weg.api_gerenciamento_transporte.repository;

import net.weg.api_gerenciamento_transporte.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {
}
