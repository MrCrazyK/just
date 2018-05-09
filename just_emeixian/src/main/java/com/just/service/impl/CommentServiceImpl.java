package com.just.service.impl;

import com.just.service.CommentService;
import com.just.dao.CommentMapper;
import com.just.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by just on 2017/12/8.
 */

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentsMapper;

    @Transactional
    public List<Comment> comments(Integer commentsId) {

        List<Comment> commentList = commentsMapper.findComments(commentsId);

        return commentList;
    }
}
