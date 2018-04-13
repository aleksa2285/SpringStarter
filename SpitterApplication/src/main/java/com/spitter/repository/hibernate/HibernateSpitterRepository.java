//package com.spitter.repository.hibernate;
//import com.spitter.repository.repositoryDefinition.SpitterRepository;
//import com.spitter.util.Spitter;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import javax.transaction.Transactional;
//import java.io.Serializable;
//import java.util.List;
//
//
//@Repository
//@Transactional
//public class HibernateSpitterRepository implements SpitterRepository
//{
//
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
////
////    public HibernateSpitterRepository(SessionFactory sessionFactory) {
////        this.sessionFactory = sessionFactory;
////    }
//
//    public HibernateSpitterRepository() {
//    }
//
//    private Session currentSession(){
//        return sessionFactory.getCurrentSession();
//    }
//
//    public void saveSpitter(Spitter spitter) {
//    }
//
//    public Spitter findByUsername(String username) {
//
//        Session session = currentSession();
//        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
//        CriteriaQuery<Spitter> query = builder.createQuery(Spitter.class);
//        Root<Spitter> root = query.from(Spitter.class);
//        query.select(root).where(builder.equal(root.get("SPITTER_USERNAME"), username));
//        Query q = session.createQuery(query);
//        Spitter spitter = (Spitter)q.getSingleResult();
//        return spitter;
//
//    }
//    public void addSpitter(Spitter spitter) {
//
//    }
//    public Spitter findOne(long id) {
//        return null;
//
//    }
//    public List<Spitter> findAll() {
//        Session session = currentSession();
//        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
//        CriteriaQuery<Spitter> query = builder.createQuery(Spitter.class);
//        Root root = query.from(Spitter.class);
//        query.select(root);
//        Query q = session.createQuery(query);
//        List<Spitter> list = q.getResultList();
//        return null;
//    }
//}
