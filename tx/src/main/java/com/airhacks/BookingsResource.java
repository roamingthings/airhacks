package com.airhacks;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("bookings")
@TransactionManagement(TransactionManagementType.BEAN)
public class BookingsResource {

    @Inject
    Event<String> events;

    @PersistenceContext
    EntityManager em;

    @Inject
    AddressValidator av;

    @Resource
    UserTransaction ut;

    @GET
    @Path("{id}")
    public Booking find(@PathParam("id") long id) {
        Booking b = this.em.find(Booking.class, id);
        b.setName("new name");
        return b;
    }

    @GET
    public String get() throws InterruptedException, ExecutionException {
        String b = "1,2";
        try {
            ut.begin();
        } catch (NotSupportedException ex) {
            Logger.getLogger(BookingsResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BookingsResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        events.fire(b);
        em.merge(new Booking(b));
        // tag::future[]
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            results.add(this.av.validateAddress());
        }
        String vals = results.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException ex) {
                return null;
            }
        }).collect(Collectors.joining(","));
        System.out.println("val = " + vals);
        // end::future[]
        try {
            ut.commit();
        } catch (RollbackException ex) {
            Logger.getLogger(BookingsResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(BookingsResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(BookingsResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BookingsResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(BookingsResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BookingsResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

}
