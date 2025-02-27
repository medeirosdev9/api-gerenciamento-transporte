package net.weg.api_gerenciamento_transporte.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.api_gerenciamento_transporte.controller.request.VeiculoRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.VeiculoResponseDTO;
import net.weg.api_gerenciamento_transporte.service.VeiculoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
@AllArgsConstructor
public class VeiculoController {
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> create(@RequestBody @Valid VeiculoRequestDTO veiculoDto) {
        try {
            VeiculoResponseDTO veiculo = veiculoService.create(veiculoDto);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<VeiculoResponseDTO> update (@RequestBody @Valid VeiculoRequestDTO veiculoDto, Long id) {
        try {
            VeiculoResponseDTO veiculo = veiculoService.update(id, veiculoDto);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/page")
    public ResponseEntity<Page<VeiculoResponseDTO>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable) {
        try {
            Page<VeiculoResponseDTO> veiculos = veiculoService.findAll(pageable);
            return new ResponseEntity<>(veiculos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> findById(@PathVariable Long id) {
        try {
            VeiculoResponseDTO veiculo = veiculoService.findById(id);
            return new ResponseEntity<>(veiculo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> delete(@PathVariable("id") Long id) {
        try {
            veiculoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

