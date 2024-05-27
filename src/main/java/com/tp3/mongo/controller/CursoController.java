package com.tp3.mongo.controller;

import com.tp3.mongo.model.Aluno;
import com.tp3.mongo.model.Curso;
import com.tp3.mongo.service.AlunoService;
import com.tp3.mongo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getCursos()
    {
        return cursoService.findAll();
    }
    @PostMapping
    public Curso createCliente(@RequestBody Curso curso)
    {
        return cursoService.save(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id)
    {
        Curso curso = cursoService.excluirAluno(id);
        return ResponseEntity.ok().body(curso);
    }

    @PutMapping("/{id}")
    public Curso updateCliente(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.updateCurso(id, curso);

    }
}
