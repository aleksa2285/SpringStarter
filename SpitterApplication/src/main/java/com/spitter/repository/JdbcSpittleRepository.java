//package com.spitter.repository;
//
//import com.spitter.repository.repositoryDefinition.SpittleRepository;
//import com.spitter.util.Spittle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class JdbcSpittleRepository implements SpittleRepository {
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcSpittleRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate =  jdbcTemplate;
//    }
//
//    public List<Spittle> findSpittles(long max, int count) {
//        return null;
//    }
//
//    public Spittle findOne(long spittleID) {
//
//        String sql = "SELECT SPITTLE_MESSAGE FROM `spittle` WHERE SPITTLE_ID = ?";
//
//        String name = (String)jdbcTemplate.queryForObject(
//                sql, new Object[] { 1 }, String.class);
//
//        return new Spittle(name,null);
//
//    }
//    public List<Spittle> mostRecentSpittles() {
//
//        String query = "SELECT * FROM `spittle` ORDER BY SPITTLE_ID desc limit 0,10 ";
//        List<Spittle> spittles = new ArrayList<Spittle>();
//
//        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
//        for(Map row: rows){
//            Spittle spittle = new Spittle();
////            spittle.setSpitter_id((Long) row.get("SPITTER_ID"));
//            spittle.setMessage((String) row.get("SPITTLE_MESSAGE"));
//            spittle.setTimestamp((Timestamp) row.get("SPITTLE_TIMESTAMP"));
//            spittle.setLongitude((BigDecimal) row.get("SPITTLE_LONGITUDE"));
//            spittle.setLatitude((BigDecimal) row.get("SPITTLE_LATITUDE"));
//            spittle.setLikes((Integer) row.get("SPITTLE_LIKES"));
//            spittle.setComments((Integer) row.get("SPITTLE_COMMENTS"));
//            spittles.add(spittle);
//        }
//        return spittles;
//    }
//
//}
