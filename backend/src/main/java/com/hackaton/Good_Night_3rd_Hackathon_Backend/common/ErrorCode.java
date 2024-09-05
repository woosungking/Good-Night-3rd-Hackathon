package com.hackaton.Good_Night_3rd_Hackathon_Backend.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    WISH_NOT_FOUND(HttpStatus.NOT_FOUND, "E001", "해당 아이디와 일치하는 소원이 없습니다.");

    private HttpStatus status;
    private String code;
    private String message;

    ErrorCode(HttpStatus status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }

};
