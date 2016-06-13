package com.airhacks;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
    public String get() {
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

        //throw new IllegalStateException("too lazy");
        av.validateAddress();
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
