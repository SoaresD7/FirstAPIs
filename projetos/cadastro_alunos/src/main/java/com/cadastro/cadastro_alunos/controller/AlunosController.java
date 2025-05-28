package com.cadastro.cadastro_alunos.controller;


// Importações necessárias
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cadastro_alunos.model.Alunos;
import com.cadastro.cadastro_alunos.service.AlunosService;

@RestController
@RequestMapping("/api/alunos")
public class AlunosController {

    @Autowired
    private AlunosService service;

    @GetMapping
    public List<Alunos> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alunos> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alunos salvar(@RequestBody Alunos alunos) {
        return service.salvar(alunos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alunos> atualizar(@PathVariable Long id, @RequestBody Alunos alunos) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alunos.setId(id);
        return ResponseEntity.ok(service.salvar(alunos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}