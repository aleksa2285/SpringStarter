package com.spitter.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


    @Entity
    public class Spittle {
        //bid like :)

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "SPITTLE_ID")
        private Long id;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="SPITTER_ID")
        private Spitter spitter_id;
        @Column(name = "SPITTLE_MESSAGE")
        private String message;
        @Column(name="SPITTLE_TIMESTAMP")
        private Timestamp timestamp;
        @Column(name = "SPITTLE_LATITUDE")
        private BigDecimal latitude;
        @Column(name = "SPITTLE_LONGITUDE")
        private BigDecimal longitude;
        @Column(name="SPITTLE_LIKES")
        private int likes;
        @Column(name="SPITTLE_COMMENTS")
        private int comments;

    public Spittle(long id, Spitter spitter_id, String message, Timestamp timestamp, BigDecimal latitude, BigDecimal longitude, int likes, int comments) {
        this.spitter_id = spitter_id;
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.likes = likes;
        this.comments = comments;
    }

    public Spittle(String message, Timestamp timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
    public Spittle() {
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Long getSpitter_id() {
        return spitter_id.getId();
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", spitter_id=" + getSpitter_id() +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }
    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, "id", "time" );
    }
}
