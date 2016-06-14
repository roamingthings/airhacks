package com.airhacks.tight.contact.boundary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author airhacks.com
 */
public class ContactsResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/contacts/resources/contacts/");
    }

    // tag::crud_test[]
    @Test
    public void crud() {
        JsonObject sample = this.tut.request(MediaType.APPLICATION_JSON).
                options(JsonObject.class);
        System.out.println("sample = " + sample);

        Response createdResponse = this.tut.request().post(Entity.json(sample));
        assertThat(createdResponse.getStatus(), is(201));

        String location = createdResponse.getHeaderString("Location");

        JsonObject freshlyCreated = this.client.target(location).
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("freshlyCreated = " + freshlyCreated);
        Assert.assertNotNull(freshlyCreated);

    }
    // end::crud_test[]

}
