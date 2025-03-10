package net.weg.api_gerenciamento_transporte.service;

import net.weg.api_gerenciamento_transporte.controller.request.MotoristaRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.MotoristaResponseDTO;
import net.weg.api_gerenciamento_transporte.model.Motorista;
import net.weg.api_gerenciamento_transporte.model.Endereco;
import net.weg.api_gerenciamento_transporte.repository.MotoristaRepository;
import net.weg.api_gerenciamento_transporte.repository.EnderecoRepository; // Repositório de Endereco
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final EnderecoRepository enderecoRepository; // Repositório de Endereco

    public MotoristaService(MotoristaRepository motoristaRepository, EnderecoRepository enderecoRepository) {
        this.motoristaRepository = motoristaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public MotoristaResponseDTO create(MotoristaRequestDTO motoristaRequestDTO) {
        // Buscar o endereço pelo ID
        Endereco endereco = enderecoRepository.findById(motoristaRequestDTO.enderecoId())
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));

        // Criar o motorista com o endereço associado
        Motorista motorista = Motorista.builder()
                .nome(motoristaRequestDTO.nome())
                .email(motoristaRequestDTO.email())
                .endereco(endereco) // Associando o endereço
                .build();

        return motoristaRepository.save(motorista).toDto();
    }

    public MotoristaResponseDTO update(Long id, MotoristaRequestDTO motoristaRequestDTO) {
        // Buscar o endereço pelo ID
        Endereco endereco = enderecoRepository.findById(motoristaRequestDTO.enderecoId())
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));

        // Atualizar o motorista com o endereço associado
        Motorista motoristaNovo = Motorista.builder()
                .id(id)
                .nome(motoristaRequestDTO.nome())
                .email(motoristaRequestDTO.email())
                .endereco(endereco)
                .build();

        return motoristaRepository.save(motoristaNovo).toDto();
    }

    public void delete(Long id) {
        motoristaRepository.deleteById(id);
    }

    public MotoristaResponseDTO findById(Long id) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Motorista não encontrado"));
        return motorista.toDto();
    }

    public Page<MotoristaResponseDTO> findAll(Pageable pageable) {
        return null;
    }
}
