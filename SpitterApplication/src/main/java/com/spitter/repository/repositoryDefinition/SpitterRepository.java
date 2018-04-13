package com.spitter.repository.repositoryDefinition;

import com.spitter.util.Spitter;

import java.util.List;

public interface SpitterRepository {
    void saveSpitter(Spitter spitter);
    void addSpitter(Spitter spitter);
    Spitter findByUsername(String username);
    Spitter findOne(long id);
    List<Spitter> findAll();
}
