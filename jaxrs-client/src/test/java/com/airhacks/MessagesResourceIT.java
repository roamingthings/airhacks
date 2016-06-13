package com.airhacks;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class MessagesResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/jax-rs/resources/messages/123");
    }

    @Test
    public void all() {
        String result = this.tut.request().get(String.class);
        System.out.println("result = " + result);
    }

}
