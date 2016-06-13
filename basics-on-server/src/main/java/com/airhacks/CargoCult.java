package com.airhacks;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Interceptors(Audit.class)
public class CargoCult {

//    @Inject
    Magician wizard;

    @Inject
    @Highly
    String message;

    @Inject
    @MyConfiguration
    String anotherMessage;

    @Inject
    @MyConfiguration("postgres.jdbc.uri")
    String jdbcURL;

    /**
     * Don't use constructors in Java EE for initialization
     */
    public CargoCult() {
        System.out.println("injected wizard = " + wizard);
    }

    @Inject
    public CargoCult(Magician wizard) {
        System.out.println("in constructor injected wizard = " + wizard);
        this.wizard = wizard;
    }

    @PostConstruct
    public void init() {
        System.out.println("--- post construct injected wizard = " + wizard);
    }

    public String getSomeMagic() {
        String magicianPerformance = this.wizard.performSomeMagic();
        return message + " --> " + anotherMessage + " -- > " + jdbcURL + magicianPerformance;
    }

}
