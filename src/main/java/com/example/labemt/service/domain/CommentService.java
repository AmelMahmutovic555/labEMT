package com.example.labemt.service.domain;

import com.example.labemt.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> listAll();
    Optional<Comment> addComment(Comment comment);
    Optional<Comment> editComment(Long id, Comment comment);
    void deleteComment(Long id);
    Optional<Comment> findById(Long id);
}
