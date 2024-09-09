package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.service;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.dao.CommentDao;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.dto.RequestComment;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentDao commentDao;
    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
    this.commentDao = commentDao;
    }

    @Override
    public void createComment(RequestComment comment) {
        Long wishId = comment.getWishId();
        commentDao.createComment(wishId, comment);
    }

    @Override
    public List<Comment> getAllComment(Long wishId) {

        return commentDao.getAllComment(wishId);
    }

    @Override
    public void deleteComment(Long commentId) {

    }
}
