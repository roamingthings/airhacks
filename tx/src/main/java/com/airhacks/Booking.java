package com.airhacks;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author airhacks.com
 */
@NamedQuery(name = "all", query = "SELECT b FROM Booking b")
@Entity
public class Booking {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    private Set<Flight> flights;

    @Column(name = "A_NAME")
    private String name;

    public Booking() {
        this.flights = new HashSet<>();
    }

    public Booking(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
