package com.airhacks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author airhacks.com
 */
@Entity
public class Booking {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "A_NAME")
    private String name;

    public Booking() {
    }

    public Booking(String name) {
        this.name = name;
    }

}
