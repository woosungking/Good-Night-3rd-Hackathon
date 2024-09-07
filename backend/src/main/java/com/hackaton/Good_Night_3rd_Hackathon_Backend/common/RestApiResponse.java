package com.hackaton.Good_Night_3rd_Hackathon_Backend.common;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.common.error.ErrorCode;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.exception.WishErrorCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

//enum 으로 오류코드를 정의(오류코드 및 메시지는 정해져있으므로 상수? 취급을 해서 열거형으로 고정) -> 사용자 응답을 할때
// 상태코드, Data도 포함이 되어야하기 때문에, 열거형 + data를 일관성 있게 입력 후 사용자에게 응답을 주기위해
//RestApiResponse 클레스를 따로 만들었음.
@Getter
@Setter
public class RestApiResponse {

    private HttpStatus status;
    private String code;
    private String message;
    private Object data;

    public RestApiResponse(SuccessCode successCode){
        this.status = successCode.getStatus();
        this.code = successCode.getCode();
        this.message = successCode.getMessage();

    }

    public RestApiResponse(SuccessCode successCode, Object data){
        this.status = successCode.getStatus();
        this.code = successCode.getCode();
        this.message = successCode.getMessage();
        this.data = data;
    }

    public RestApiResponse(ErrorCode errorCode){
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
    public RestApiResponse(ErrorCode errorCode, Object data){
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.data = data;
    }
}
