package com.tp3.mongo.service;

import com.tp3.mongo.model.Aluno;
import com.tp3.mongo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();

    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno buscarAlunoPorId(@PathVariable Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno excluirAluno(@PathVariable Long id) {
        Aluno aluno = alunoRepository.findById(id);
        alunoRepository.delete(aluno);
        return aluno;
    }

    public Aluno updateAluno(@PathVariable Long id, Aluno aluno) {
        Aluno alun = alunoRepository.findById(id);
        alun.setNome(aluno.getNome());
        alun.setTelefone(aluno.getTelefone());

        return alunoRepository.save(alun);
    }
}
