//package com.spitter.repository;
//
//import com.spitter.repository.repositoryDefinition.SpitterRepository;
//import com.spitter.util.Spitter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class JdbcSpitterRepository implements SpitterRepository {
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcSpitterRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void saveSpitter(Spitter spitter) {
//
//    }
//    public Spitter findByUsername(String username) {
//        return null;
//    }
//
//    public void addSpitter(Spitter spitter) {
//        jdbcTemplate.update("INSERT INTO `spitter` (SPITTER_USERNAME, SPITTER_EMAIL, SPITTER_PASSWORD) VALUES (?, ?, ?)",
//                spitter.getUsername(),
//                spitter.getEmail(),
//                spitter.getPassword());
//    }
//
//    public Spitter findOne(long id) {
//       return null;
//    }
//
//    public List<Spitter> findAll() {
//        return null;
//    }
////    private static final class SpitterRowMapper implements RowMapper<Spitter>{
////        public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
////            return new Spitter(
////                    resultSet.getLong("SPITTER_ID"),
////                    resultSet.getString("SPITTER_USERNAME"),
////                    resultSet.getString("SPITTER_EMAIL"),
////                    resultSet.getString("SPITTER_PASSWORD"));
////        }
////    }
//}
