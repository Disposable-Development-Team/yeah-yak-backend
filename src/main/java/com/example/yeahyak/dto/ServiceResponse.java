package com.example.yeahyak.dto;

import com.example.yeahyak.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ServiceResponse {
    private String code;
    private Object item;

}
