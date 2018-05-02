package com.spitter.repository.repositoryDefinition;

import com.spitter.util.Reetweet;
import com.spitter.util.Spittle;

public interface RetweetRepository {
    void createRetweet(Reetweet retweet);
    void removeRetweet(Reetweet retweet);
    void fetchReetweets(Spittle spittle);
}
