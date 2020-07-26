package com.ynz.democloud.guestreservation.webservice;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue
    @Column(name = "RESERVATION_ID")
    private Long id;

    @Column(name = "ROOM_ID")
    private Long roomId;

    @Column(name = "GUEST_ID")
    private Long guestId;

    @Column(name = "RES_DATE")
    @Getter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date restDate;

    public String getRestDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(restDate);
    }
}
