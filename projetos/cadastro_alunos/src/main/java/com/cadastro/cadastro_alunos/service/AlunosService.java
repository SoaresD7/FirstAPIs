package com.cadastro.cadastro_alunos.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cadastro.cadastro_alunos.model.Alunos;
import com.cadastro.cadastro_alunos.repository.AlunosRepository;

@Service
public class AlunosService {

    @Autowired
    private AlunosRepository repository;

    public List<Alunos> listarTodos() {
        return repository.findAll();
    }

    public Optional<Alunos> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Alunos salvar(Alunos alunos) {
        return repository.save(alunos);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}