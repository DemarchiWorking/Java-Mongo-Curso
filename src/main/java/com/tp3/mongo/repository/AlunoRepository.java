package com.tp3.mongo.repository;

import com.tp3.mongo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

    public Aluno findById(Long id);
}
