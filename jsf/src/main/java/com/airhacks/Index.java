package com.airhacks;

import java.util.Set;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.Size;

/**
 *
 * @author airhacks.com
 */
@Model
public class Index {

    @Size(min = 2, max = 5)
    private String message;

    @Inject
    Validator validator;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object save() {
        System.out.println("--- " + message);
        Set<ConstraintViolation<Index>> violations = validator.validate(this);
        return null;
    }

}
