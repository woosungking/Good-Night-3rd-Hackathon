package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.exception;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.common.error.BusinessException;

public abstract class WishException extends BusinessException {
    protected WishException(WishErrorCode wishErrorCode){
        super(wishErrorCode);
    }
    public static class NotFoundWishException extends WishException{
        public NotFoundWishException(){
            super(WishErrorCode.WISH_NOT_FOUND);
            //WISH_NOT_FOUND(HttpStatus.NOT_FOUND, "E001", "해당 아이디에 일치하는 소원이 없습니다.");
        }
    }
}
