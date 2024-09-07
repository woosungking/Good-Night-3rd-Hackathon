package com.hackaton.Good_Night_3rd_Hackathon_Backend.common.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException{
    private HttpStatus status;
    private String code;
    private ErrorCode errorCode;
    //궁금점 : 필드에 Message필드는 왜 없지? => RuntimeException에 이미 message라는 필드를 가지고 있음.
    // 추가적인 정보를 주기위해 임의로 status랑 code필드를 초가해서 사용하는거임.
    //궁금점2 : 현제 필드에 message를 정의해서 사용하면 안되는것인가, => YES, 가능은 하지만 부모의 필드랑 겹치는데 에초에 부모클레스에
    //Message 필드 관련 포멧방식이랑 이런게 다 있으므로, 그걸 그대로 이용하는게 좋음.
    public BusinessException(ErrorCode errorCode){
        super(errorCode.getMessage()); // 위에서 설명한것처럼 부모의 생성자를 호출해서 message만 초기화 해줌.
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.errorCode = errorCode;
    }
}
