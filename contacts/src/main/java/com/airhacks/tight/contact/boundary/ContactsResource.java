package com.airhacks.tight.contact.boundary;

import com.airhacks.tight.contact.entity.Contact;
import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
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
@Stateless
@Path("contacts")
public class ContactsResource {

    @Inject
    ContactsService service;

    @GET
    public JsonArray contacts() {
        return Json.createArrayBuilder().
                add(contact("1")).
                build();
    }

    // tag::options_sample[]
    @OPTIONS
    public JsonObject sample() {
        return contact("sample " + service.street());
    }
    // end::options_sample[]

    @GET
    @Path("{id}")
    public JsonObject find(@PathParam("id") long id) {
        return contact("javasteet " + id);
    }

    @POST
    public Response save(JsonObject contact, @Context UriInfo info) {
        Contact createdContact = this.service.saveOrUpdate(deserialize(contact));
        URI uri = info.getAbsolutePathBuilder().path("/" + createdContact.getId()).build();
        return Response.created(uri).build();
    }

    Contact deserialize(JsonObject object) {
        return new Contact(object.getString("address"));
    }

    JsonObject serialize(Contact contact) {
        return Json.createObjectBuilder().
                add("address", contact.getStreet()).
                build();
    }

    public JsonObject contact(String street) {
        return Json.createObjectBuilder().
                add("address", street).
                build();
    }

}
