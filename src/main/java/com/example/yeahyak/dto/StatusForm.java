package com.example.yeahyak.dto;

import com.example.yeahyak.entity.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class StatusForm {
    private Status status;

    @JsonProperty("status")
    private void unpackNested(Long id){
        this.status = new Status(); // 객체 생성
        status.setStatus(id);
    }
}
