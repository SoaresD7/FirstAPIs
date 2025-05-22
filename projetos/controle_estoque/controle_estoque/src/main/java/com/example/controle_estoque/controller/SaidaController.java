package com.example.controle_estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controle_estoque.model.Saida;
import com.example.controle_estoque.service.SaidaService;

@RestController
@RequestMapping("/api/saidas")
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
