package com.airhacks;

import javax.enterprise.inject.Model;
import javax.validation.constraints.Size;

/**
 *
 * @author airhacks.com
 */
@Model
public class Index {

    @Size(min = 2, max = 5)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object save() {
        System.out.println("--- " + message);
        return null;
    }

}
