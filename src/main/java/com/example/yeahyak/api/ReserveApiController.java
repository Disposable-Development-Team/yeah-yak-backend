package com.example.yeahyak.api;


import com.example.yeahyak.dto.ReservationForm;
import com.example.yeahyak.dto.StatusForm;
import com.example.yeahyak.entity.Reservation;
import com.example.yeahyak.entity.Status;
import com.example.yeahyak.repository.ReservationRepository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @GetMapping(value = "/reservations" ,params = {"name", "phonenumber"})
    public List<Reservation> getReservationDetails(@RequestParam("name") String name ,
                       @RequestParam("phonenumber" ) String phonenumber){
     return reservationRepository.findByNameAndPhoneNumber(name, phonenumber);
    }

    @PostMapping("/reservations")
    public String PostReservations(@RequestBody ReservationForm dto){
        log.info("dto :"+ dto);
        Reservation dto_entity = dto.toEntity();
        log.info("entity: "+dto_entity);
        Reservation saved = reservationRepository.save(dto_entity);
        log.info("savedata : " + saved);
        return "ok";
    }
    @PostMapping("/reservations/{id}")
    public String UpdateReservations(@PathVariable Long id,
                                     @RequestBody StatusForm dto){
        Reservation reservationEntity = reservationRepository.findById(id).orElse(null);
        log.info("dto : "  + dto.toString());
        log.info("reservationEntity " + reservationEntity);
        reservationEntity.setStatus(dto.getStatus());
        reservationRepository.save(reservationEntity);
        return "ok";
    }

//    @PostMapping("/test")
//    public String test(@)


}
