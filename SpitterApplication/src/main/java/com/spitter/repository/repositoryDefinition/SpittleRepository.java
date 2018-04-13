package com.spitter.repository.repositoryDefinition;

import com.spitter.util.Spittle;

import java.util.List;

public interface SpittleRepository {

    List<Spittle> findAll();
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long spittleID);
}
