package com.cadastro.cadastro_alunos.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cadastro.cadastro_alunos.model.Aluno;
import com.cadastro.cadastro_alunos.repository.AlunosRepository;

@Service
public class AlunosService {

    @Autowired
    private AlunosRepository repository;

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Aluno salvar(Aluno alunos) {
        return repository.save(alunos);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}