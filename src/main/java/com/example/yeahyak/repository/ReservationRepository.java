package com.example.yeahyak.repository;

import com.example.yeahyak.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    Optional<Reservation> findByid(Long id);
    ArrayList<Reservation> findAll();
}
