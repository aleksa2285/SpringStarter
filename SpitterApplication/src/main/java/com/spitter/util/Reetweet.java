package com.spitter.util;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Reetweet {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="REETWEET_ID")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SPITTER_ID")
    private Spitter spitter_id;
    @Column(name="RETWEET_MESSAGE")
    private String message;
    @Column(name="RETWEET_TIMESTAMP")
    private Timestamp timestamp;
    @Column(name="RETWEET_LONGITUDE")
    private BigDecimal longitude;
    @Column(name="RETWEET_LATITUDE")
    private BigDecimal latitude;
    @Column(name="RETWEET_LIKES")
    private int likes;
    @Column(name="RETWEET_COMMENTS")
    private int comments;

    public Reetweet() {
    }
    public Reetweet(long id, String message, Timestamp timestamp, BigDecimal longitude, BigDecimal latitude, int likes, int comments) {
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
        this.longitude = longitude;
        this.latitude = latitude;
        this.likes = likes;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public Spitter getSpitter_id() {
        return spitter_id;
    }

    public void setSpitter_id(Spitter spitter_id) {
        this.spitter_id = spitter_id;
    }

    @Override
    public String toString() {
        return "Reetweet{" +
                "id=" + id +
                ", spitter_id=" + spitter_id +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}
