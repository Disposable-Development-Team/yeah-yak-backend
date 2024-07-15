package com.example.yeahyak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString

@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status")
    private Long status;

    @Column
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "status")
    private List<Reservation> reservationList = new ArrayList<>();

}
