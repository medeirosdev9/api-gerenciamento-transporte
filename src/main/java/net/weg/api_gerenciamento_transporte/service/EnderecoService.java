package net.weg.api_gerenciamento_transporte.service;

import net.weg.api_gerenciamento_transporte.controller.request.EnderecoRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.EnderecoResponseDTO;
import net.weg.api_gerenciamento_transporte.controller.response.RotaResponseDTO;
import net.weg.api_gerenciamento_transporte.model.Endereco;
import net.weg.api_gerenciamento_transporte.model.Rota;
import net.weg.api_gerenciamento_transporte.repository.EnderecoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;

    public EnderecoResponseDTO create(EnderecoRequestDTO enderecoRequestDTO) {
        Endereco endereco = enderecoRepository.save(enderecoRequestDTO.toEntity());
        return endereco.toDto();
    }

    public EnderecoResponseDTO update(Long id, EnderecoRequestDTO enderecoRequestDTO) {
        Endereco enderecoNovo = enderecoRequestDTO.toEntity();
        enderecoNovo.setId(id);
        Endereco endereco = enderecoRepository.save(enderecoNovo);
        return endereco.toDto();
    }

    public void delete(Long id){
        enderecoRepository.deleteById(id);
    }

    public EnderecoResponseDTO findById(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return endereco.toDto();
    }

    public Page<EnderecoResponseDTO> findAll(Pageable pageable) {
        return enderecoRepository.findAll(pageable).map(Endereco::toDto);
    }
}

