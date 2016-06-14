package com.airhacks;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class AddressValidator {

    // tag::session_context_rollback[]
    @Resource
    SessionContext sc;

    @Asynchronous
    public Future<String> validateAddress() {
        try {
            //sc.setRollbackOnly();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AddressValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<>("42-" + System.currentTimeMillis());
    }
    // end::session_context_rollback[]

}
