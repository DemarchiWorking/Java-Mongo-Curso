package com.tp3.mongo.service;

import com.tp3.mongo.model.Aluno;
import com.tp3.mongo.model.Curso;
import com.tp3.mongo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso buscarAlunoPorId(@PathVariable Long id) {
        return cursoRepository.findById(id);
    }

    public Curso excluirAluno(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id);
        cursoRepository.delete(curso);
        return curso;
    }
    public Curso updateCurso(@PathVariable Long id, Curso curso) {
        Curso curs = cursoRepository.findById(id);
        curs.setNome(curso.getNome());

        return cursoRepository.save(curs);
    }
}
