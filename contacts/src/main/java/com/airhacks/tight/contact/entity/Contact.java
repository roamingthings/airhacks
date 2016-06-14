package com.airhacks.tight.contact.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author airhacks.com
 */
@Entity
public class Contact {

    @Id
    @GeneratedValue
    private long id;

    private String street;

    public Contact(String street) {
        this.street = street;
    }

    public Contact() {
    }

    public long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

}
