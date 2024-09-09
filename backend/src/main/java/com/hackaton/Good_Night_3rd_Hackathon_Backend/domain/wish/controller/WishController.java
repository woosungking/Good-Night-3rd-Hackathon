package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.controller;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.common.RestApiResponse;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.common.SuccessCode;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.dao.WishDao;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.dto.ConfirmYN;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.entity.Wish;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.service.WishService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wish")
public class WishController {

    private final WishDao wishDao;
    private  final WishService wishService;

    @Autowired //의존성 주입.
    public WishController(WishDao wishDao, WishService wishService) {
        this.wishDao = wishDao;
        this.wishService = wishService;
    }

    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RestApiResponse> createWish(@RequestBody Wish wish) {
        wishService.createWish(wish);
        RestApiResponse response = new RestApiResponse(SuccessCode.WISH_CREATE_SUCCESS);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RestApiResponse> getWish(@PathVariable("id") Long id) {
        Wish wish = wishService.getWish(id);
        RestApiResponse response = new RestApiResponse(SuccessCode.FIND_WISH, wish);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    // 전체 Wish 리스트를 조회하는 엔드포인트
    @GetMapping("/list") // 소원리스트 쭉 뽑기
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RestApiResponse> getWishList() {
        RestApiResponse response = new RestApiResponse(SuccessCode.FIND_WISH_LIST, wishService.getWishList());
        return ResponseEntity.ok(response);

    }
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RestApiResponse> deleteWish(@PathVariable("id") Long id){
        wishService.deleteWish(id);
        RestApiResponse response = new RestApiResponse(SuccessCode.DELETE_WISH);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/approval/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<RestApiResponse> approvalWish(@PathVariable("id") Long id, @RequestBody ConfirmYN request)
    {
        wishService.confirmWish(id, request.getConfirm());
        RestApiResponse response = new RestApiResponse(SuccessCode.CONFIRM_WISH);
        return ResponseEntity.ok(response);
    }
}

