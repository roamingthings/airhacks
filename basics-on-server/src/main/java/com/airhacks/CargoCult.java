package com.airhacks;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.transaction.TransactionSynchronizationRegistry;

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

    @Resource //contains state in a TX
    TransactionSynchronizationRegistry tsr;

    /**
     * Don't use constructors in Java EE for initialization
     */
    public CargoCult() {
        System.out.println("injected wizard = " + wizard);
    }

    @Inject
    public CargoCult(@Magic(Magic.Kind.WHITE) Magician wizard) {
        System.out.println("in constructor injected wizard = " + wizard);
        this.wizard = wizard;
    }

    @PostConstruct
    public void init() {
        System.out.println("--- post construct injected wizard = " + wizard);
    }

    public String getSomeMagic() {
        String magicianPerformance = this.wizard.performSomeMagic();
        return message + " --> " + anotherMessage + " -- > " + jdbcURL + " magician:" + magicianPerformance;
    }

}
