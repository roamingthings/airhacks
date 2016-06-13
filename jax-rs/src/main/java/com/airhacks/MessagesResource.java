package com.airhacks;

import java.net.URI;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author airhacks.com
 */
@Path("messages")
public class MessagesResource {

    @GET
    public JsonObject message() {
        return Json.createObjectBuilder().add("name", "duke").build();
    }

    @POST
    public Response save(JsonObject object, @Context UriInfo info) {
        System.out.println("--- " + object);
        URI uri = info.getAbsolutePathBuilder().
                path("/" + System.currentTimeMillis()).
                build();
        return Response.created(uri).build();
    }

    @GET
    @Path("{id}")
    public Message findMessage(@PathParam("id") long id) {
        return new Message("negotiated", 12);
    }
}
