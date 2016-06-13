package com.airhacks;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("bookings")
public class BookingsResource {

    @Inject
    Event<String> events;

    @PersistenceContext
    EntityManager em;

    @Inject
    AddressValidator av;

    @GET
    public String get() {
        String b = "1,2";
        events.fire(b);
        em.merge(new Booking(b));
        //throw new IllegalStateException("too lazy");
        av.validateAddress();
        return b;
    }

}
