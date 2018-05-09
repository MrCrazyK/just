package com.just.entity;

import java.util.Date;

public class Comment {
        private int commentId;
        //评论主键
        //评论内容
        private String contents;
        //评论是回复哪个评论
        private int answerFor;
        //评论时间
        private Date commentTime;
        //评论属于哪个用户/管理员
        private User user;
        //评论属于哪个商品
        private Product product;


        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }


        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }


        public int getAnswerFor() {
            return answerFor;
        }

        public void setAnswerFor(int answerFor) {
            this.answerFor = answerFor;
        }

        public Date getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(Date commentTime) {
            this.commentTime = commentTime;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }





        public Comment(int commentId, String contents, int answerFor, Date commentTime, User user, Product product) {
            this.commentId = commentId;
            this.contents = contents;
            this.answerFor = answerFor;
            this.commentTime = commentTime;
            this.user = user;
            this.product = product;
        }

        public Comment() {
            super();
        }

        @Override
        public String toString() {
            return "Comments{" +
                    "cid=" + commentId +
                    ", contents='" + contents + '\'' +
                    ", answerFor='" + answerFor + '\'' +
                    ", commentTime=" + commentTime +
                    ", user=" + user +
                    ", product=" + product +
                    '}';
        }
    }


