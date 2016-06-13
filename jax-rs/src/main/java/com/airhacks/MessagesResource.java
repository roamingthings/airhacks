package com.airhacks;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
    public void save(JsonObject object) {
        System.out.println("--- " + object);
    }

}
