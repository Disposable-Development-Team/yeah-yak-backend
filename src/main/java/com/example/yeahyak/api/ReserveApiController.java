package com.example.yeahyak.api;


import com.example.yeahyak.dto.ReservationForm;
import com.example.yeahyak.entity.Reservation;
import com.example.yeahyak.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReserveApiController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public List<Reservation> index(){
        return reservationRepository.findAll();
    }

    @GetMapping("/reservations/{id}")
    public Reservation show(@PathVariable Long id){
        return reservationRepository.findById(id).orElse(null);
    }

    @PostMapping("/reservations")
    public Reservation create(@RequestBody ReservationForm dto){
        Reservation reservation = dto.toEntity();
        return reservationRepository.save(reservation);
    }


}
