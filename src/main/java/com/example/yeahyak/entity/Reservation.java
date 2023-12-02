package com.example.yeahyak.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성 전략
    private Long id;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private String startdate;
    @Column
    private String enddate;
    @Column
    private String status;
}
