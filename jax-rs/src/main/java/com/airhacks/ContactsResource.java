package com.airhacks;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("contacts")
public class ContactsResource {

    @Inject
    ContactsStore store;

    @Resource
    ManagedExecutorService mes;

    @GET
    public void all(@Suspended AsyncResponse response) {
        response.setTimeout(10, TimeUnit.SECONDS);
        CompletableFuture.supplyAsync(store::contacts).thenAccept(response::resume);
    }

}
