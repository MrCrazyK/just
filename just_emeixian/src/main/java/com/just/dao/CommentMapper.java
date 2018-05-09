package com.just.dao;

import com.just.entity.Comment;

import java.util.List;

public interface CommentMapper {
    public List<Comment> findComments(Integer productId);
}
