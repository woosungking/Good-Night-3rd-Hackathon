package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.controller;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.dao.CommentDao;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.dto.RequestComment;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.entity.Comment;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/comment")
@RestController
@Controller
public class CommentController {
    CommentService commentService;
    @Autowired
    CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:5173")
    public void createComment(@RequestBody RequestComment comment){
        commentService.createComment(comment);
        //Comment안에 wishId도 넣어서 올거임.
    }

    @PatchMapping("/softdelete/{comment_id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public void softDeleteComment(@PathVariable("comment_id") Long comment_id){
        commentService.deleteComment(comment_id);
    }

    @GetMapping("/{wishId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Comment> getComment(@PathVariable("wishId") Long wishId){
        return commentService.getAllComment(wishId);
    }
}
