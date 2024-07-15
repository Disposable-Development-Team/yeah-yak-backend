package com.example.yeahyak.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    @JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss" , timezone= "Asia/Seoul")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss" , timezone= "Asia/Seoul")
    private LocalDateTime updatedDate;




}
