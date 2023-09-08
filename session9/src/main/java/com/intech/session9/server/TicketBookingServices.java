package com.intech.session9.server;

import com.intech.session9.domain.TicketBooking;
import com.intech.session9.repository.TicketBookingRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class TicketBookingServices {
    private TicketBookingRepo ticketBookingRepo;
//    @Transactional(noRollbackFor = {RuntimeException.class}) //default rollback on throw RuntimeException making stopping that
//    @Transactional(rollbackFor = Exception.class)  // setting rollback on  Exception throw
//    @Transactional(propagation = Propagation.REQUIRED) //Spring checks if there is an active transaction, and if nothing exists, it creates a new one. Otherwise, the business logic appends to the currently active transaction
//    @Transactional(propagation = Propagation.REQUIRES_NEW ) //Spring suspends the current transaction if it exists, and then creates a new one
//    @Transactional(propagation = Propagation.NOT_SUPPORTED) //If a current transaction exists, first Spring suspends it, and then the business logic is executed without a transaction
//    @Transactional(propagation = Propagation.SUPPORTS)  //Spring first checks if an active transaction exists. If a transaction exists, then the existing transaction will be used. If there isn’t a transaction, it is executed non-transactional:
//    @Transactional(propagation = Propagation.MANDATORY) //if there is an active transaction, then it will be used. If there isn’t an active transaction, then Spring throws an exception
//    @Transactional(propagation = Propagation.NEVER) //Spring throws an exception if there’s an active transaction:
//    @Transactional(isolation = Isolation.DEFAULT) //default database isolation
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED) //The rest of the concurrency side effects could still happen. So uncommitted changes in concurrent transactions have no impact on us, but if a transaction commits its changes, our result could change by re-querying
//    @Transactional(isolation = Isolation.REPEATABLE_READ) //So we are not affected by uncommitted changes in concurrent transactions
//    @Transactional(isolation = Isolation.SERIALIZABLE) //highest level of isolation. It prevents all mentioned concurrency side effects, but can lead to the lowest concurrent access rate because it executes concurrent calls sequentially.
    public void save() {
        for (int i = 0; i < 10; i++) {
            ticketBookingRepo.save(getTicket(i));
            t2();  //printing the Transactional data or not
            if (!checkAvailability(i)) {
                System.out.println("Going to commit");
//                throw new RuntimeException("failed to book ticket");
            }
        }
        System.out.println("completed for look");

        //commit
    }

    private static int ticket = 2;

    private Boolean checkAvailability(int i) {
        if (i < ticket) {
            ticket--;
            return true;
        }
        return false;
    }

    private TicketBooking getTicket(int i) {
        return TicketBooking.builder()
                .name("Customer" + i)
                .qty(i)
                .amount(new Random().nextInt(100 - 1) + 1)
                .build();
    }

    @Transactional
    public void t2() {
        List<TicketBooking> list = ticketBookingRepo.findAll();
        list.forEach(System.out::println);
    }
}
