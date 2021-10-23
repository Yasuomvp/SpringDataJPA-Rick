package com.rick.springdatajparick.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @OneToMany(mappedBy = "person",targetEntity = Car.class,cascade = CascadeType.ALL)
    private Set<Car> carSet = new HashSet<Car>(0);

    public Person(){}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", carSet=" + carSet +
                '}';
    }

    public Person(int id, String username, Set<Car> carSet) {
        this.id = id;
        this.username = username;
        this.carSet = carSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }
}
