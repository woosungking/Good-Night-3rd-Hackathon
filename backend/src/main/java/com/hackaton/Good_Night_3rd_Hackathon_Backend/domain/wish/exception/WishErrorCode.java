package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.exception;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.common.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum WishErrorCode implements ErrorCode { // @Getter 어노테이션으로 인해 오버라이딩 별도로 안해도 됩니당.

    WISH_NOT_FOUND(HttpStatus.NOT_FOUND, "E001", "해당 아이디에 일치하는 소원이 없습니다.");

    private HttpStatus status;
    private String code;
    private String message;

    WishErrorCode(HttpStatus status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }

};
