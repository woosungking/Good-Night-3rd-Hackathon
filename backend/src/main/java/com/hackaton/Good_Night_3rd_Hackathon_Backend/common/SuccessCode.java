package com.hackaton.Good_Night_3rd_Hackathon_Backend.common;

import org.springframework.http.HttpStatus;

public enum SuccessCode {
    WISH_CREATE_SUCCESS(HttpStatus.CREATED,"W001","소원 등록 완료"),
    FIND_WISH(HttpStatus.OK, "W002", "소원 조회 성공"),
    FIND_WISH_LIST(HttpStatus.OK, "W003","소원 리스트 조회 성공"),
    DELETE_WISH(HttpStatus.OK,"W004","소원 삭제 성공"),
    CONFIRM_WISH(HttpStatus.OK,"W005","소원 승인 완료");



    private HttpStatus status;
    private String code;
    private String message;
    SuccessCode(HttpStatus status, String code, String message){
        this.status=status;
        this.code=code;
        this.message=message;
    }
}
