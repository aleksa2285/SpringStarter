package com.spitter.repository.hibernate;

import com.spitter.repository.repositoryDefinition.SpittleRepository;
import com.spitter.util.Spittle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional

public class HibernateSpittleRepository implements SpittleRepository {


    private SessionFactory sessionFactory;

    private SpittleRepository spittleRepository;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory){
//        this.sessionFactory = sessionFactory;
//    }
//    public Session getCurrentSession(){
//        return this.sessionFactory.getCurrentSession();
//    }
    @Transactional(readOnly = true)
    public List<Spittle> findAll() {
//        List<Spittle> list = sessionFactory.getCurrentSession().createQuery("from Spittle s").list();
//        System.out.println(list.toString());
//        return list;
        return null;
    }
    @Transactional(readOnly = true)
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }
    @Transactional(readOnly = true)
    public Spittle findOne(long spittleID)
    {
        return null;
//        getCurrentSession().get(Spittle.class, spittleID);
    }
    @Transactional(readOnly = true)
    public Collection<Spittle> findAllTweetsByUser(long spitter_id) {
//        CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
//        CriteriaQuery<Spittle> criteria = builder.createQuery(Spittle.class);
//        criteria.from(Spittle.class);
//        Collection<Spittle> spittles = getCurrentSession().createQuery(criteria).getResultList();
//        return spittles;
        return null;
    }


}
