package com.web.recruit.service;

import com.web.recruit.entity.Post;

import java.util.Map;

public interface PostService {

    void createPost(Post post);

    void deletePost(Integer postId);

    void updatePost(Post post);

    Map<String, Object> findPost(Integer postId);

    Map<String, Object> findAllPosts();

    Map<String, Object> findPostByKey(String keyword);

}
