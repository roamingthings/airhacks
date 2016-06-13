package com.airhacks;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class AddressValidator {

    @Resource
    SessionContext sc;

    public void validateAddress() {
        sc.setRollbackOnly();
    }

}
