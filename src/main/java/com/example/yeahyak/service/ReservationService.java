package com.example.yeahyak.service;

import com.example.yeahyak.dto.ReservationForm;
import com.example.yeahyak.dto.StatusForm;
import com.example.yeahyak.entity.Reservation;
import com.example.yeahyak.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservationAll(){

        return reservationRepository.findAll();
    }
    public List<Reservation> getReservationDetails(String name, String phoneNumber){

        return reservationRepository.findByNameAndPhoneNumber(name, phoneNumber);
    }
    public Reservation postReservation(ReservationForm dto){
        Reservation reservation = dto.toEntity();
        return reservationRepository.save(reservation);
    }
    public Reservation updateReservation(Long id, StatusForm dto){
        Reservation reservationEntity = reservationRepository.findById(id).orElse(null);
        reservationEntity.setStatus(dto.getStatus());
        return reservationRepository.save(reservationEntity);
    }

}
