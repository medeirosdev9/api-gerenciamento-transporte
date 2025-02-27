package net.weg.api_gerenciamento_transporte.service;

import net.weg.api_gerenciamento_transporte.controller.request.MotoristaRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.EnderecoResponseDTO;
import net.weg.api_gerenciamento_transporte.controller.response.MotoristaResponseDTO;
import net.weg.api_gerenciamento_transporte.model.Endereco;
import net.weg.api_gerenciamento_transporte.model.Motorista;
import net.weg.api_gerenciamento_transporte.repository.MotoristaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MotoristaService {
    private MotoristaRepository motoristaRepository;

    public Motorista create(MotoristaRequestDTO motoristaRequestDTO) {
        Motorista motorista = motoristaRequestDTO.toEntity();
        return motoristaRepository.save(motorista);
    }

    public MotoristaResponseDTO update(Long id, MotoristaRequestDTO motoristaRequestDTO) {
        Motorista motoristaNovo = motoristaRequestDTO.toEntity();
        motoristaNovo.setId(id);
        Motorista motorista = motoristaRepository.save(motoristaNovo);
        return motorista.toDto();
    }

    public void delete(Long id) {
        motoristaRepository.deleteById(id);
    }

    public MotoristaResponseDTO findById(Long id) {
        Motorista motorista = motoristaRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return motorista.toDto();
    }

    public Page<MotoristaResponseDTO> findAll(Pageable pageable) {
        return motoristaRepository.findAll(pageable).map(Motorista::toDto);
    }
}
