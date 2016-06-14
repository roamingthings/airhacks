package com.airhacks;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author airhacks.com
 */
// tag::embeddedenum[]
@Qualifier
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Magic {

    Kind value();

    enum Kind {
        WHITE, BLACK
    }
}
// end::embeddedenum[]
