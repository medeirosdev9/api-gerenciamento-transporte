package net.weg.api_gerenciamento_transporte.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.api_gerenciamento_transporte.controller.request.EnderecoRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.EnderecoResponseDTO;
import net.weg.api_gerenciamento_transporte.model.Endereco;
import net.weg.api_gerenciamento_transporte.service.EnderecoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
@AllArgsConstructor
public class EnderecoController {
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> create(@RequestBody @Valid EnderecoRequestDTO enderecoDto) {
        try {
            EnderecoResponseDTO endereco = enderecoService.create(enderecoDto);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<EnderecoResponseDTO> update (@RequestBody @Valid EnderecoRequestDTO enderecoDto, Long id) {
        try {
            EnderecoResponseDTO endereco = enderecoService.update(id, enderecoDto);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/page")
    public ResponseEntity<Page<EnderecoResponseDTO>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable) {
        try {
            Page<EnderecoResponseDTO> enderecos = enderecoService.findAll(pageable);
            return new ResponseEntity<>(enderecos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> findById(@PathVariable Long id) {
        try {
            EnderecoResponseDTO endereco = enderecoService.findById(id);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> delete(@PathVariable Long id) {
        try {
            enderecoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
