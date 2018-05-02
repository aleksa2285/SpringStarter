package com.spitter.repository.repositoryDefinition;

import com.spitter.util.Reetweet;
import com.spitter.util.Spitter;
import com.spitter.util.Spittle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface SpitterRepository {
    void saveSpitter(Spitter spitter);
    void addSpitter(Spitter spitter);
    Spitter findByUsername(String username);
    Spitter findOne(long id);
    List<Spitter> findAll();
    Collection<Spittle> findUserTweets(long spitter_id);
    Collection<Reetweet> findUserRetweets(long spitter_id);
    public Collection findUserTweetsAndRetweets(long spitter_id);
}
