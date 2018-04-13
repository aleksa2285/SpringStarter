//package com.spitter.repository.jpa;
//
//        import com.spitter.repository.repositoryDefinition.SpitterRepository;
//        import com.spitter.util.Spitter;
//        import org.springframework.stereotype.Repository;
//        import javax.persistence.EntityManager;
//        import javax.persistence.PersistenceContext;
//        import javax.transaction.Transactional;
//        import java.util.List;
//
//@Repository
//@Transactional
//public class JpaSpitterRepository implements SpitterRepository {
//
//    @PersistenceContext
//    private EntityManager emf;
//
//    @Transactional
//    public void saveSpitter(Spitter spitter) {
//        emf.merge(spitter);
//    }
//    public void addSpitter(Spitter spitter){
//        emf.persist(spitter);
//    }
//
//    public Spitter findByUsername(String username) {
//        return emf.find(Spitter.class, username);
//    }
//
//    public Spitter findOne(long id) {
//        return emf.find(Spitter.class, id);
//    }
//
//    public List<Spitter> findAll() {
//        return null;
//    }
//}
