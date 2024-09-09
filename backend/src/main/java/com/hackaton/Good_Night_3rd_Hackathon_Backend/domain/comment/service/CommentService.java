package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.service;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.dto.RequestComment;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.entity.Comment;

import java.util.List;

public interface CommentService {

    public void createComment(RequestComment comment);
    public List<Comment> getAllComment(Long wishId);
    public void deleteComment(Long commentId);

}
