package net.weg.api_gerenciamento_transporte.service;

import net.weg.api_gerenciamento_transporte.controller.request.VeiculoRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.MotoristaResponseDTO;
import net.weg.api_gerenciamento_transporte.controller.response.VeiculoResponseDTO;
import net.weg.api_gerenciamento_transporte.model.Motorista;
import net.weg.api_gerenciamento_transporte.model.Veiculo;
import net.weg.api_gerenciamento_transporte.repository.VeiculoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class VeiculoService {
    private VeiculoRepository veiculoRepository;

    public VeiculoResponseDTO create(VeiculoRequestDTO veiculoRequestDTO) {
        Veiculo veiculo = veiculoRequestDTO.toEntity();
        return veiculoRepository.save(veiculo).toDto();
    }

    public VeiculoResponseDTO update(Long id, VeiculoRequestDTO veiculoRequestDTO) {
        Veiculo veiculoNovo = veiculoRequestDTO.toEntity();
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

