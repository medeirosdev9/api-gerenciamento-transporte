package net.weg.api_gerenciamento_transporte.service;

import net.weg.api_gerenciamento_transporte.controller.request.VeiculoRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.VeiculoResponseDTO;
import net.weg.api_gerenciamento_transporte.model.Motorista;
import net.weg.api_gerenciamento_transporte.model.Veiculo;
import net.weg.api_gerenciamento_transporte.repository.MotoristaRepository;
import net.weg.api_gerenciamento_transporte.repository.VeiculoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;
    private final MotoristaRepository motoristaRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, MotoristaRepository motoristaRepository) {
        this.veiculoRepository = veiculoRepository;
        this.motoristaRepository = motoristaRepository;
    }

    public VeiculoResponseDTO create(VeiculoRequestDTO veiculoRequestDTO) {
        Motorista motorista = motoristaRepository.findById(veiculoRequestDTO.motoristaId()).orElseThrow(() -> new IllegalArgumentException("Motorista não encontrado"));
        Veiculo veiculo = veiculoRequestDTO.toEntity(motorista);
        return veiculoRepository.save(veiculo).toDto();
    }


    public VeiculoResponseDTO update(Long id, VeiculoRequestDTO veiculoRequestDTO) {
        Motorista motorista = motoristaRepository.findById(veiculoRequestDTO.motoristaId()).orElseThrow(() -> new IllegalArgumentException("Motorista não encontrado"));
        Veiculo veiculoNovo = veiculoRequestDTO.toEntity(motorista);
        veiculoNovo.setId(id);
        Veiculo veiculo = veiculoRepository.save(veiculoNovo);
        return veiculo.toDto();
    }


    public void delete(Long id) {
        veiculoRepository.deleteById(id);
    }

    public VeiculoResponseDTO findById(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return veiculo.toDto();
    }

    public Page<VeiculoResponseDTO> findAll(Pageable pageable) {
        return veiculoRepository.findAll(pageable).map(Veiculo::toDto);
    }
}

