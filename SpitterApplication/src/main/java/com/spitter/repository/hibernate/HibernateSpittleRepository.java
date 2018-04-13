package com.spitter.repository.hibernate;

import com.spitter.repository.repositoryDefinition.SpittleRepository;
import com.spitter.util.Spittle;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@org.springframework.transaction.annotation.Transactional

public class HibernateSpittleRepository implements SpittleRepository {


    private SessionFactory sessionFactory;
    @Autowired
    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }
    @Transactional(readOnly = true)
    public List<Spittle> findAll() {
        List<Spittle> list = sessionFactory.getCurrentSession().createQuery("from Spittle s").getResultList();
        System.out.println(list.toString());
        return list;
    }
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    public Spittle findOne(long spittleID) {
        return null;
    }

}
