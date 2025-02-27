package net.weg.api_gerenciamento_transporte.service;

import jakarta.validation.Valid;
import net.weg.api_gerenciamento_transporte.controller.request.RotaRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.RotaResponseDTO;
import net.weg.api_gerenciamento_transporte.model.Rota;
import net.weg.api_gerenciamento_transporte.repository.RotaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RotaService {
    private RotaRepository rotaRepository;

    public RotaResponseDTO create(@Valid RotaRequestDTO rotaResponseDTO) {
        Rota rota = rotaResponseDTO.toEntity();
        return rotaRepository.save(rota).toDto();
    }

    public RotaResponseDTO update(Long id, @Valid RotaRequestDTO rotaResponseDTO) {
        Rota rotaNovo = rotaResponseDTO.toEntity();
        rotaNovo.setId(id);
        Rota rota = rotaRepository.save(rotaNovo);
        return rota.toDto();
    }

    public void delete(Long id) {
        rotaRepository.deleteById(id);
    }

    public RotaResponseDTO findById(Long id) {
        Rota rota = rotaRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return rota.toDto();
    }

    public Page<RotaResponseDTO> findAll(Pageable pageable) {
        return rotaRepository.findAll(pageable).map(Rota::toDto);
    }
}
