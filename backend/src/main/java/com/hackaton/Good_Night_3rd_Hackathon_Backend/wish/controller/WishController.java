package com.hackaton.Good_Night_3rd_Hackathon_Backend.wish.controller;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.wish.dao.WishDao;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.wish.dto.ConfirmYN;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.wish.entity.Wish;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.wish.service.WishService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/wish")
@AllArgsConstructor
public class WishController {

    private final WishDao wishDao;
    private  final WishService wishService;

//    @Autowired //의존성 주입.
//    public WishController(WishDao wishDao, WishService wishService) {
//        this.wishDao = wishDao;
//        this.wishService = wishService;
//    }

    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<> createWish(@RequestBody Wish wish) {

        wishService.createWish(wish);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Wish getWish(@PathVariable("id") Long id) {
        Wish wish = wishService.getWish(id);
        return wish;
    }

    // 전체 Wish 리스트를 조회하는 엔드포인트
    @GetMapping("/list") // 소원리스트 쭉 뽑기
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Wish> getWishList() {
        return wishService.getWishList();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteWish(@PathVariable("id") Long id){
        wishService.deleteWish(id);
        return;
    }

    @PatchMapping("/approval/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public void approvalWish(@PathVariable("id") Long id, @RequestBody ConfirmYN request)
    {

        wishService.confirmWish(id, request.getConfirm());
    };
}