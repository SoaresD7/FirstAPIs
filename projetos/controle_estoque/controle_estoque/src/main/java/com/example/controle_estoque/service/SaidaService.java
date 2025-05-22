package com.example.controle_estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controle_estoque.model.Saida;
import com.example.controle_estoque.repository.SaidaRepository;

@Service
public class SaidaService {

    @Autowired
    private SaidaRepository saidaRepository;

    public List<Saida> listarTodas() {
        return saidaRepository.findAll();
    }

    public Optional<Saida> buscarPorId(Long id) {
        return saidaRepository.findById(id);
    }

    public Saida salvar(Saida saida) {
        return saidaRepository.save(saida);
    }

    public void deletar(Long id) {
        saidaRepository.deleteById(id);
    }
}
