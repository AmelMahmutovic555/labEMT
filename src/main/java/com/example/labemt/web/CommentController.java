package com.example.labemt.web;

import com.example.labemt.model.Comment;
import com.example.labemt.service.domain.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> listAllComments(){
        return commentService.listAll();
    }

    @GetMapping("/{id}")
    public Optional<Comment> findById(@PathVariable Long id){
        return commentService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        return commentService.addComment(comment).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Comment> editComment(@PathVariable Long id, @RequestBody Comment comment){
        if (commentService.findById(id).isPresent()) {
            commentService.editComment(id, comment);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        if (commentService.findById(id).isPresent()){
            commentService.deleteComment(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
