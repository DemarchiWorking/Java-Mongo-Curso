package com.tp3.mongo.repository;

import com.tp3.mongo.model.Aluno;
import com.tp3.mongo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, String> {

    public Curso findById(Long id);
}
