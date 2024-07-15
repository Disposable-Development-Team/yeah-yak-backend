package com.example.yeahyak.repository;

import com.example.yeahyak.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    @Override
    Optional<Reservation> findById(Long id);
    ArrayList<Reservation> findAllByOrderByCreatedDateDesc();

    List<Reservation> findByNameAndPhoneNumberOrderByCreatedDateDesc(String name, String phoneNumber);
    @Override
    void deleteById(Long id);
}
