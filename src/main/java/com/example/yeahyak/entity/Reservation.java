package com.example.yeahyak.entity;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "reservation")
public class Reservation extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성 전략
    private Long id;

    @Column
    private String name;

    @Column
    private String room;

    @Column
    private String phoneNumber;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status")
    private Status status;



}
