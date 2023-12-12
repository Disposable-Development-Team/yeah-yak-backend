package com.example.yeahyak.api;


import com.example.yeahyak.dto.ReservationForm;
import com.example.yeahyak.entity.Reservation;
import com.example.yeahyak.repository.ReservationRepository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ReserveApiController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public List<Reservation> getReservationAll(){
        return reservationRepository.findAll();
    }

    @GetMapping("/reservations/details")
    public List<Reservation> getReservationDetails(@RequestParam("name") String name ,
                       @RequestParam("phonenumber" ) String phonenumber){
     return reservationRepository.findByNameAndPhonenumber(name, phonenumber);
    }

    @PostMapping("/reservations")
    public String PostReservations(@RequestBody ReservationForm dto){
        Reservation dto_entity = dto.toEntity();
        Reservation saved = reservationRepository.save(dto_entity);
        log.info("savedata : " + saved);
        return "ok";
    }
    @PostMapping("/reservations/details/{id}")
    public String UpdateReservations(@PathVariable Long id,
                                     @RequestParam("status") Long status){
        Reservation reservationEntity = reservationRepository.findById(id).orElse(null);
        reservationEntity.setStatus(status);
        reservationRepository.save(reservationEntity);
        return "ok";
    }


}
