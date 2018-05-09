package com.just.service;

import com.just.entity.Comment;

import java.util.List;

/**
 * Created by just on 2017/12/8.
 */
public interface CommentService {
    public List<Comment> comments(Integer commentsId);

}
