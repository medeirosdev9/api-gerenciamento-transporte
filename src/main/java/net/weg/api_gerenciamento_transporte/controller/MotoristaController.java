package net.weg.api_gerenciamento_transporte.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.api_gerenciamento_transporte.controller.request.MotoristaRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.request.MotoristaRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.MotoristaResponseDTO;
import net.weg.api_gerenciamento_transporte.controller.response.MotoristaResponseDTO;
import net.weg.api_gerenciamento_transporte.model.Motorista;
import net.weg.api_gerenciamento_transporte.service.MotoristaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/motoristas")
@AllArgsConstructor
public class MotoristaController {
    private MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<Motorista> create(@RequestBody @Valid MotoristaRequestDTO motoristaDto) {
        try {
            Motorista motorista = motoristaService.create(motoristaDto);
            return new ResponseEntity<>(motorista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<MotoristaResponseDTO> update (@RequestBody @Valid MotoristaRequestDTO motoristaDto, Long id) {
        try {
            MotoristaResponseDTO motorista = motoristaService.update(id, motoristaDto);
            return new ResponseEntity<>(motorista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/page")
    public ResponseEntity<Page<MotoristaResponseDTO>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable) {
        try {
            Page<MotoristaResponseDTO> motoristas = motoristaService.findAll(pageable);
            return new ResponseEntity<>(motoristas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaResponseDTO> findById(@PathVariable Long id) {
        try {
            MotoristaResponseDTO motorista = motoristaService.findById(id);
            return new ResponseEntity<>(motorista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MotoristaResponseDTO> delete(@PathVariable("id") Long id) {
        try {
            motoristaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}