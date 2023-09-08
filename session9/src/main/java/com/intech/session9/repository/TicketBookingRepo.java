package com.intech.session9.repository;

import com.intech.session9.domain.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingRepo extends JpaRepository<TicketBooking,Long> {
}
