package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.service;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.entity.Wish;

import java.util.List;

public interface WishService {
    public void createWish(Wish wish);

    public Wish getWish(Long id);

    public List<Wish> getWishList();

    public void deleteWish(Long id);

    public void confirmWish(Long id, boolean confirm);

}
