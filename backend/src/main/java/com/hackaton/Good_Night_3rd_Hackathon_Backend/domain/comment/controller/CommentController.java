package com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.controller;

import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.dao.CommentDao;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.entity.Comment;
import com.hackaton.Good_Night_3rd_Hackathon_Backend.domain.comment.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/comment")
@RestController
@Controller
public class CommentController {
    CommentService commentService;

    @PostMapping("/create")
    public void createComment(@RequestBody Comment comment){
        commentService.createComment(comment);
        //Comment안에 wishId도 넣어서 올거임.
    }

    @PatchMapping("/softdelete/{comment_id}")
    public void softDeleteComment(@PathVariable("comment_id") Long comment_id){
        commentService.deleteComment(comment_id);
    }

    @GetMapping("/{wish_id}")
    public List<Comment> getComment(@PathVariable("wish_id") Long wish_id){
        return commentService.getAllComment(wish_id);
    }
}
