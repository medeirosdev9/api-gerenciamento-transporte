package net.weg.api_gerenciamento_transporte.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.api_gerenciamento_transporte.controller.request.RotaRequestDTO;
import net.weg.api_gerenciamento_transporte.controller.response.RotaResponseDTO;
import net.weg.api_gerenciamento_transporte.model.Rota;
import net.weg.api_gerenciamento_transporte.service.RotaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rotas")
@AllArgsConstructor
public class RotaController {
    private RotaService rotaService;
    @PostMapping
    public ResponseEntity<Rota> create(@RequestBody @Valid RotaRequestDTO rotaDto) {
        try {
            Rota rota = rotaService.create(rotaDto).toEntity();
            return new ResponseEntity<>(rota, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<RotaResponseDTO> update (@RequestBody @Valid RotaRequestDTO rotaDto, Long id) {
        try {
            RotaResponseDTO rota = rotaService.update(id, rotaDto);
            return new ResponseEntity<>(rota, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/page")
    public ResponseEntity<Page<RotaResponseDTO>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable) {
        try {
            Page<RotaResponseDTO> rotas = rotaService.findAll(pageable);
            return new ResponseEntity<>(rotas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RotaResponseDTO> findById(@PathVariable Long id) {
        try {
            RotaResponseDTO rota = rotaService.findById(id);
            return new ResponseEntity<>(rota, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RotaResponseDTO> delete(@PathVariable Long id) {
        try {
            rotaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
