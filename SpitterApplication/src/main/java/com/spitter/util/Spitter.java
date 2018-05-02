package com.spitter.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
//item like
public class Spitter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SPITTER_ID")
    private Long id;
    @NotNull
    @Size(min = 5, max = 30, message = "{username.size}")
    @Column(name="SPITTER_USERNAME")
    private String username;
    @NotNull
    @Size(min = 10, max = 40)
    @Column(name="SPITTER_EMAIL")
    private String email;
    @NotNull
    @Size(min = 6, max = 40, message = "{password.size}")
    @Column(name="SPITTER_PASSWORD")
    private String password;
    @Column(name="SPITTER_PROFILE_PICTURE")
    private String pathProfle;
    @OneToMany(mappedBy = "spitter_id", cascade = CascadeType.ALL)
    //@org.hibernate.annotations.OnDelete(
    // action = org.hibernate.annotations.OnDeleteAction.CASCADE - we only need one DELETE statement to remove all dependent data recursively, and nothing has to be loaded into application (server) memory. versus  DATA INTEGRITY ]
    //[cascading options. PERSIST ili CascadeType.DELETE]

    //IF you work on a new scehma, however, the easiest approach is to not enable database level cascading and map a composition relationship in your domain model as embeded/embeddable, not as entity association-
    //Hibernate can then execute efficient SQL DELETE opertions to remove the entire composite...
    // )

    //Prednost bag-ova naspram listi je što pri dodavanju novih spittle-a u kolekciju, kolekcija ne mora biti incijalizovana iz početka ( tj. ne moraju se prvobitno load-ovati svi spittle-ovli. U slučaju sa setovima i ostalim listama je tako)

    private Collection<Spittle> userSpittles = new ArrayList<Spittle>();
    @OneToMany(mappedBy = "spitter_id", cascade = CascadeType.ALL)
    private Collection<Reetweet> userRetweets = new ArrayList<Reetweet>();


    public Spitter() {
    }
    public Spitter(String email, String username, String password, String pathProfle) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.pathProfle = pathProfle;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Collection<Spittle> getUserSpittles() {
        return userSpittles;
    }
    public void setUserSpittles(Set<Spittle> userSpittles) {
        this.userSpittles = userSpittles;
    }
    public String getPathProfle() {
        return pathProfle;
    }

    public void setPathProfle(String pathProfle) {
        this.pathProfle = pathProfle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setUserSpittles(Collection<Spittle> userSpittles) {
        this.userSpittles = userSpittles;
    }
    public Collection<Reetweet> getUserRetweets() {
        return userRetweets;
    }
    public void setUserRetweets(Collection<Reetweet> userRetweets) {
        this.userRetweets = userRetweets;
    }

    @Override
    public String toString() {
        return "Spitter{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", pathProfle='" + pathProfle + '\'' +
                ", userSpittles=" + userSpittles +
                '}';
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this, that, "id", "lastname", "username", "password");
    }
    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, "id", "password" );
    }
}
