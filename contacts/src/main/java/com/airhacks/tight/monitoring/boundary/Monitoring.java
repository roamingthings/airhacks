package com.airhacks.tight.monitoring.boundary;

import com.airhacks.tight.contact.entity.Contact;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("monitoring")
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class Monitoring {

    AtomicLong success;
    AtomicLong failure;

    @PostConstruct
    public void init() {
        this.success = new AtomicLong();
        this.failure = new AtomicLong();
    }

    public void onContactCreated(@Observes(during = TransactionPhase.AFTER_SUCCESS) Contact contact) {
        this.success.incrementAndGet();
    }

    public void onContactRejected(@Observes(during = TransactionPhase.AFTER_FAILURE) Contact contact) {
        this.failure.incrementAndGet();
    }

    @DELETE
    public void reset() {
        this.success.set(0);
    }

    @GET
    public JsonObject get() {
        return Json.createObjectBuilder().
                add("created-contacts", this.success.longValue()).
                add("rejected", this.failure.longValue()).
                build();
    }

}
