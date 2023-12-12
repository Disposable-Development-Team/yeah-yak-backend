package com.example.yeahyak.entity;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter

public class Reservation extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성 전략
    private Long id;

    @Column
    private String name;

    @Column
    private String room;

    @Column
    private String phonenumber;

    @Column
    private LocalDate startdate;

    @Column
    private LocalDate enddate;

    @Column
    private Long status;
}
