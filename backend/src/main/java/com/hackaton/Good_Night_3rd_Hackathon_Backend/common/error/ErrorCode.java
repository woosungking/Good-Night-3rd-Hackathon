package com.hackaton.Good_Night_3rd_Hackathon_Backend.common.error;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    //상속 받는 enum에서 getter를 구현하도록 인터페이스 작성.
    HttpStatus getStatus();
    String getCode();
    String getMessage();

}
