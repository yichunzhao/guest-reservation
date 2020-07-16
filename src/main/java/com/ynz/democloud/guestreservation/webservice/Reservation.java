package com.ynz.democloud.guestreservation.webservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long id;

    @Column(name = "ROOM_ID")
    private Long roomId;

    @Column(name = "GUEST_ID")
    private Long guestId;

    @Column(name = "RES_DATE")
    private Date restDate;

}
