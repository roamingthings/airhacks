package com.airhacks;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author airhacks.com
 */
public class BookingListener {

    public void onSuccessfulBooking(@Observes(during = TransactionPhase.AFTER_SUCCESS) String booking) {
        System.out.println("++event- " + booking);
    }

    public void onFailedBooking(@Observes(during = TransactionPhase.AFTER_FAILURE) String booking) {
        System.out.println("--event- " + booking);
    }

}
