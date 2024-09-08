package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.service;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.dao.WishDao;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.wish.entity.Wish;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class WishServiceImpl implements WishService{
    private WishDao wishDao;

    @Override
    public void createWish(Wish wish) {
        wishDao.createWish(wish);

    }

    @Override
    public Wish getWish(Long id) {
        Wish wish = new Wish();
        wish = wishDao.getWish(id);
        return wish;
    }

    @Override
    public List<Wish> getWishList() {
        List<Wish> wish = new ArrayList<Wish>();
        wish = wishDao.getWishList();
        return wish;
    }

    @Override
    public void deleteWish(Long id) {
        wishDao.deleteWish(id);

    }

    @Override
    public void confirmWish(Long id, boolean confirm) {
        wishDao.confirmWish(id,confirm);
    }
}
