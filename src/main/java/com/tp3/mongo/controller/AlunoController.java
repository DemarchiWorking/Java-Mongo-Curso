package com.tp3.mongo.controller;

import com.tp3.mongo.model.Aluno;
import com.tp3.mongo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAlunos() {
       return alunoService.listarAlunos();

    }

    @GetMapping("{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        return alunoService.buscarAlunoPorId(id);

    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id)
    {
        Aluno cliente = alunoService.excluirAluno(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping("/{id}")
    public Aluno updateCliente(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.updateAluno(id, aluno);

    }
}
