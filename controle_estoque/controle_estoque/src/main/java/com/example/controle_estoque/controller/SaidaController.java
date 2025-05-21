package com.example.controle_estoque.controller;

import com.example.controle_estoque.model.Saida;
import com.example.controle_estoque.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saidas")
@CrossOrigin(origins = "*")
public class SaidaController {

    @Autowired
    private SaidaService saidaService;

    @GetMapping
    public List<Saida> listar() {
        return saidaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saida> buscar(@PathVariable Long id) {
        return saidaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Saida salvar(@RequestBody Saida saida) {
        return saidaService.salvar(saida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        saidaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
