package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.service;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.dao.CommentDao;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.entity.Comment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentDao commentDao;
    @Override
    @CrossOrigin(origins = "http://localhost:5173")
    public void createComment(Comment comment) {
        Long wishId = comment.getWish_id();
        commentDao.createComment(wishId, comment);
    }

    @Override
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Comment> getAllComment(Long wishId) {
        return null;
    }

    @Override
    @CrossOrigin(origins = "http://localhost:5173")
    public void deleteComment(Long commentId) {

    }
}
