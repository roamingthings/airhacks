package com.airhacks;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 *
 * @author airhacks.com
 */
@Path("messages")
public class MessagesResource {

    @GET
    public JsonObject message() {
        //return Json.createObjectBuilder().add("name", "duke").build();
        throw new IllegalStateException("too lazy");
    }

    // tag::post[]
    @POST
    public Response save(JsonObject object, @Context UriInfo info) {
        System.out.println("--- " + object);
        URI uri = info.getAbsolutePathBuilder().
                path("/" + System.currentTimeMillis()).
                build();
        return Response.created(uri).build();
    }
    // end::post[]

    // tag::location_get[]
    @Path("{id}")
    public MessageResource findMessage(@PathParam("id") long id) {
        return new MessageResource(id);
    }
    // end::location_get[]
}
