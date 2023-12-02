package com.example.yeahyak.dto;

import com.example.yeahyak.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ReservationForm {
    private Long id;
    private String name;
    private String location;
    private String startdate;
    private String enddate;
    private String status;

    public Reservation toEntity(){
        return new Reservation(id,name,location,startdate,enddate,status);
    }
}
