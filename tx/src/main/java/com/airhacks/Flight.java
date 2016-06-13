package com.airhacks;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author airhacks.com
 */
@Entity
public class Flight {

    @Id
    String flightNumber;

}
