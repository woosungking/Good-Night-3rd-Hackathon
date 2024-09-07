package com.hackaton.Good_Night_3rd_Hackathon_Backend.common.error;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.common.RestApiResponse;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.exception.WishErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<RestApiResponse> handleBusinessException(BusinessException e){
        log.error("Exception occurred: code = {}, message = {}", e.getCode(), e.getMessage(), e);
        RestApiResponse response = new RestApiResponse(e.getErrorCode());
        return ResponseEntity.status(e.getStatus()).body(response);
    }
}
