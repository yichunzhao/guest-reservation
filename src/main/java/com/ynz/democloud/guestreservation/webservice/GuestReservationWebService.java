package com.ynz.democloud.guestreservation.webservice;


import com.ynz.democloud.guestreservation.domain.Reservation;
import com.ynz.democloud.guestreservation.domain.ReservationRepository;
import com.ynz.democloud.guestreservation.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("reservations")
@RequiredArgsConstructor
public class GuestReservationWebService {
    private final ReservationRepository reservationRepository;

    @PostMapping("guests/{guestId}/rooms/{roomId}/dates/{restDate}")
    public ResponseEntity<Reservation> createReservation(@PathVariable("guestId") long guestId
            , @PathVariable("roomId") long roomId, @PathVariable("restDate") Date restDate) {
        Reservation reservation = new Reservation();
        reservation.setRoomId(roomId);
        reservation.setGuestId(guestId);
        reservation.setRestDate(restDate);

        Reservation saved = reservationRepository.save(reservation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("guests/{guestId}")
    public ResponseEntity<Reservation> findReservationByGuestId(@PathVariable("guestId") long guestId) {
        Reservation reservation = reservationRepository.findByGuestId(guestId)
                .orElseThrow(() -> new NotFoundException("Guest: " + guestId + " is not found"));
        return new ResponseEntity<>(reservation, HttpStatus.FOUND);
    }

    @GetMapping("dates/{restDate}")
    public ResponseEntity<List<Reservation>> findReservationsByDate(@PathVariable("restDate") Date date) {
        List<Reservation> reservations = reservationRepository.findByRestDate(date);
        return ResponseEntity.status(HttpStatus.FOUND).body(reservations);
    }

}
