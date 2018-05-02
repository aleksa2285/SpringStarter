package com.spitter.repository.hibernate;

import com.spitter.repository.repositoryDefinition.SpitterRepository;
import com.spitter.util.Reetweet;
import com.spitter.util.Spitter;
import com.spitter.util.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Repository
@Transactional
public class HibernateSpitterRepository implements SpitterRepository
{

    //Native query -> for fetching tweets & retweets
    final static String fetchTweetsAndRetweets = "SELECT  null as `REETWEET_ID` , `SPITTER_ID`, `SPITTLE_ID` , `SPITTLE_MESSAGE`, `SPITTLE_TIMESTAMP`, `SPITTLE_LIKES`, `SPITTLE_COMMENTS` FROM `Spittle` WHERE `SPITTER_ID` = 1\n" +
            "UNION\n" +
            "SELECT  `REETWEET_ID`, `SPITTER_ID`, `SPITTLE_ID`, `RETWEET_MESSAGE`, `RETWEET_TIMESTAMP`, `RETWEET_LIKES`, `RETWEET_COMMENTS` FROM `Reetweet` WHERE `SPITTER_ID` = 1\n" +
            "ORDER BY `SPITTLE_TIMESTAMP`";

    @PersistenceUnit
    private EntityManagerFactory em;
//    private SessionFactory sessionFactory;
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
    @Qualifier("entityManagerFactory")
    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory){
        this.em = entityManagerFactory;
    }

    public HibernateSpitterRepository() {
    }
//    private Session getCurrentSession(){
//        return sessionFactory.getCurrentSession();
//    }

    public void saveSpitter(Spitter spitter) {
    }
    public Spitter findByUsername(String username) {
        return null;
//        getCurrentSession().get(Spitter.class, username);
    }
    public void addSpitter(Spitter spitter) {
    }
    public Spitter findOne(long id) {
        return em.createEntityManager().find(Spitter.class, id);
        //em.createEntityManager().find(Spitter.class, id);
//   Hibernate sessionFactory     (Spitter)getCurrentSession().get(Spitter.class, id);
    }
    public List<Spitter> findAll() {
        return null;
    }

    public Collection<Spittle> findUserTweets(long spitter_id) {
        return findOne(spitter_id).getUserSpittles();
    }
    public Collection<Reetweet> findUserRetweets(long spitter_id) {
        return null;
//        return findOne(spitter_id).getUserRetweets();
    }
    public List<Object[]> findUserTweetsAndRetweets(long spitter_id){
        return em.createEntityManager().createNativeQuery(fetchTweetsAndRetweets).getResultList();
    }
}
