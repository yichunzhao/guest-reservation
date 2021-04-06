package com.ynz.democloud.guestreservation.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Optional<Reservation> findByGuestId(Long guestId);

    List<Reservation> findByRestDate(Date date);
}
