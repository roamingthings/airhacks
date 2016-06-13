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
    Wizard wizard;

    @Inject
    @Highly
    String message;

    /**
     * Don't use constructors in Java EE for initialization
     */
    public CargoCult() {
        System.out.println("injected wizard = " + wizard);
    }

    @Inject
    public CargoCult(Wizard wizard) {
        System.out.println("in constructor injected wizard = " + wizard);
        this.wizard = wizard;
    }

    @PostConstruct
    public void init() {
        System.out.println("--- post construct injected wizard = " + wizard);
    }

    public String getSomeMagic() {
        return message;
    }

}
