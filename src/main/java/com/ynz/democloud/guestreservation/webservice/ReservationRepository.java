package com.ynz.democloud.guestreservation.webservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Optional<Reservation> findByGuestId(Long guestId);
}
