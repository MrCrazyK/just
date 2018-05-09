package com.just.controller;

import com.just.service.CommentService;
import com.just.Util.FastJson_All;
import com.just.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by just on 2017/12/8.
 */

@Controller
@RequestMapping("comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("comments.do")
    public void commentsId(Integer productId, HttpServletResponse response){

        System.out.print("---------------_____--------__---_--_-_-------"+productId);
        Map maps = new HashMap();
        List<Comment> con = commentService.comments(productId);

        if (con.size()!=0){
            maps.put("success",con);

        }else {

            maps.put("error",con);
        }
        FastJson_All.toJson(maps,response);

    }

}
