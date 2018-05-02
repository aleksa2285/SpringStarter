package com.spitter.util;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COMMENT_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SPITTER_ID", nullable = false)
    private Spitter spitter_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SPITTLE_ID", nullable = false)
    private Spittle spittle_id;
    @Column(name="COMMENT_TIMESTAMP")
    private Timestamp timestamp;
    @Column(name="COMMENT_MESSAGE")
    private String message;
    @Column(name="COMMENT_LIKES")
    private int likes;

    public Comment() {
    }

    public Comment(Long id, Long spitter_id, Long spittle_id, Timestamp timestamp, String message, int likes) {
        this.id = id;
        this.timestamp = timestamp;
        this.message = message;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

//    public Long getSpitter_id() {
//        return spitter_id;
//    }
//
//    public void setSpitter_id(Long spitter_id) {
//        this.spitter_id = spitter_id;
//    }
//
//    public Long getSpittle_id() {
//        return spittle_id;
//    }
//
//    public void setSpittle_id(Long spittle_id) {
//        this.spittle_id = spittle_id;
//    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", spitter_id=" + spitter_id +
                ", spittle_id=" + spittle_id +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", likes=" + likes +
                '}';
    }
}
