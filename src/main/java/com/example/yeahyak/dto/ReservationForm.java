package com.example.yeahyak.dto;

import com.example.yeahyak.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@NoArgsConstructor  // 중요!
@AllArgsConstructor
@ToString
public class ReservationForm {
    private Long id;

    private String name;

    private String room;

    private String phonenumber;

    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate startdate;

    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate enddate;

    private Long status;

//    @JsonFormat(pattern = )
//    private LocalDateTime createddate;

    public Reservation toEntity(){
        return new Reservation(id,name,room,phonenumber,startdate,enddate,status);
    }

}
