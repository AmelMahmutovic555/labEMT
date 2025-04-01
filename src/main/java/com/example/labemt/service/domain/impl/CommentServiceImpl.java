package com.example.labemt.service.domain.impl;

import com.example.labemt.model.Comment;
import com.example.labemt.repository.CommentRepository;
import com.example.labemt.service.domain.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> listAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> addComment(Comment comment) {
        return Optional.of(commentRepository.save(new Comment(comment.getFirstName(), comment.getLastName(), comment.getEmail(), comment.getSubject(), comment.getMessage())));
    }

    @Override
    public Optional<Comment> editComment(Long id, Comment comment) {
        Comment comment1 = commentRepository.findById(id).orElse(null);
        comment1.setFirstName(comment.getFirstName());
        comment1.setLastName(comment.getLastName());
        comment1.setEmail(comment.getEmail());
        comment1.setSubject(comment.getSubject());
        comment1.setMessage(comment.getMessage());
        return Optional.of(commentRepository.save(comment1));
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }


}
