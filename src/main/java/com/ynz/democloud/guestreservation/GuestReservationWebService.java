package com.ynz.democloud.guestreservation;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class GuestReservationWebService {
    private final ReservationRepository reservationRepository;

    @PostMapping("/guests/{guestId}/rooms/{roomId}/dates/{restDate}")
    public ResponseEntity<Reservation> createReservation(@PathVariable("guestId") long guestId
            , @PathVariable("roomId") long roomId, @PathVariable("restDate") Date restDate) {
        Reservation reservation = new Reservation();
        reservation.setRoomId(roomId);
        reservation.setGuestId(guestId);
        reservation.setRestDate(restDate);

        Reservation saved = reservationRepository.save(reservation);
        return new ResponseEntity(saved, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(r -> reservations.add(r));
        return new ResponseEntity(reservations, HttpStatus.OK);
    }

    @GetMapping("/guests/{guestId}")
    public ResponseEntity<List<Reservation>> findReservationByGuestId(@PathVariable("guestId") long guestId) {
        List<Reservation> reservations = reservationRepository.findByGuestId(guestId);
        return new ResponseEntity(reservations, HttpStatus.FOUND);
    }

}
