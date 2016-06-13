package com.airhacks;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
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

    @GET
    public String get() {
        String b = "1,2";
        events.fire(b);
        throw new IllegalStateException("too lazy");
        //return b;
    }

}
