//package com.spitter.repository;
//
//import com.spitter.repository.repositoryDefinition.SpittleRepository;
//import com.spitter.util.Spittle;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//public class JPASpittleRepository implements SpittleRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//    public List<Spittle> findSpittles(long max, int count) {
//        return null;
//    }
//
//    public Spittle findOne(long spittleID) {
//        return null;
//    }
//
//    @Transactional
//    public List<Spittle> mostRecentSpittles() {
//
//        CriteriaQuery<Spittle> criteriaQuery = em.getCriteriaBuilder().createQuery(Spittle.class);
//        @SuppressWarnings("unused")
//        Root<Spittle> root = criteriaQuery.from(Spittle.class);
//          List<Spittle> nesto = em.createQuery(criteriaQuery).getResultList();
//        System.out.println(nesto.toString());
//        return em.createQuery(criteriaQuery).getResultList();
//
//
//    }
//}
