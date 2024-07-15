package com.example.yeahyak.dto;

import com.example.yeahyak.entity.Reservation;
import com.example.yeahyak.entity.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor  // 중요!
@AllArgsConstructor
@ToString
public class ReservationForm {
    private Long id;

    private String name;
    //room 기본값 :1로 할당
    private String room = String.valueOf('1');


    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private Status status = unpackNested(Long.valueOf(1));
    @JsonProperty("status")
    private Status unpackNested(Long id){
        this.status = new Status();
        status.setStatus(id);
        return status;
    }

    public Reservation toEntity(){
        return new Reservation(id,name,room,phoneNumber,startDate,endDate,status);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
