package com.example.yeahyak.api;


import com.example.yeahyak.dto.ReservationForm;
import com.example.yeahyak.dto.StatusForm;
import com.example.yeahyak.dto.ServiceResponse;
import com.example.yeahyak.entity.Reservation;



import com.example.yeahyak.service.EmailService;
import com.example.yeahyak.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@Tag(name = "예약")
public class ReserveApiController {


    @Autowired
    private ReservationService reservationService;
    private ServiceResponse success;
    @Autowired
    private EmailService emailService;

    @Operation(summary = "예약 정보 전체 불러오기 api " )
    @GetMapping("/reservations")
    public ResponseEntity<ServiceResponse> getReservationAll(){

        List<Reservation> data =  reservationService.getReservationAll();
        ServiceResponse set = new ServiceResponse("R001",data);
        return new ResponseEntity<>(set,HttpStatus.OK);

    }

    @Parameter(name="name" ,description = "사용자 이름")
    @Parameter(name = "phoneNumber", description = "ex) xxx-xxxx-xxxx의 형태")
    @GetMapping(value = "/reservations" ,params = {"name", "phoneNumber"})
    public ResponseEntity<ServiceResponse> getReservationDetails(@RequestParam("name") String name ,
                                                                 @RequestParam("phoneNumber" ) String phoneNumber){
        List<Reservation> details = reservationService.getReservationDetails(name,phoneNumber);
        if (!details.isEmpty()){
            ServiceResponse success = new ServiceResponse("R001", details);
            return new ResponseEntity<>(success,HttpStatus.OK);
        }
        else{
            ServiceResponse fail = new ServiceResponse("E001",details);
            return new ResponseEntity<>(fail,HttpStatus.BAD_REQUEST);
        }

    }
//
    @Operation(summary = " 예약 정보 저장 api " )
    @PostMapping("/reservations")
    public ResponseEntity<ServiceResponse> postReservations(
                                        @RequestBody ReservationForm dto) throws Exception{
        Reservation saved = reservationService.postReservation(dto);
        emailService.sendReservationEmail(dto);
        return new ResponseEntity<>(new ServiceResponse("R001",saved),HttpStatus.CREATED);
    }
    @Operation(summary = "status 변경 api" )
    @PostMapping("/reservations/{id}")
    public ResponseEntity<ServiceResponse> updateReservations(
                                   @PathVariable("id") Long id,
                                   @RequestBody StatusForm dto) throws Exception{
        Reservation saved = reservationService.updateReservation(id,dto);
        System.out.println(saved);
        ServiceResponse success = new ServiceResponse("R001",saved);
        Long status = dto.getStatus().getStatus();
        if (status == 3){
            emailService.sendCancellationEmail(saved);
        }
        return new ResponseEntity<>(success,HttpStatus.CREATED);
    }
    @Operation(summary = "예약 정보 삭제 api")
    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<ServiceResponse> deleteReservation(@PathVariable("id") Long id) {
        boolean deleted = reservationService.deleteReservation(id);
        if (deleted) {
            return new ResponseEntity<>(new ServiceResponse("R001", "Reservation deleted successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ServiceResponse("E002", "Reservation not found"), HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("/testMail")
//    public void mail(@RequestBody StatusForm dto){
//
//        System.out.println(dto.getStatus().getStatus().getClass());
//    }

}
