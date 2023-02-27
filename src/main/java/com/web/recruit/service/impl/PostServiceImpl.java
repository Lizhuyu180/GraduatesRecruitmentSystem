package com.web.recruit.service.impl;


import com.web.recruit.entity.Post;
import com.web.recruit.mapper.PostMapper;
import com.web.recruit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public void createPost(Post post) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        post.setCreationDate(date);
        this.postMapper.save(post);
    }

    @Override
    public void deletePost(Integer postId) {
        this.postMapper.delete(postId);
    }

    @Override
    public void updatePost(Post post) {
        this.postMapper.update(post);
    }

    @Override
    public Map<String, Object> findPost(Integer postId) {
        Map<String, Object> attributes = new HashMap<>();
        Post post = this.postMapper.find(postId);
        attributes.put("post", post);
        return attributes;
    }

    @Override
    public Map<String, Object> findAllPosts() {
        Map<String, Object> attributes = new HashMap<>();
        List<Post> allPosts = this.postMapper.findAll();
        // all posts
        attributes.put("posts", allPosts);
        // provide a new data transfer object
        attributes.put("postDto", new Post());
        return attributes;
    }

    @Override
    public Map<String, Object> findPostByKey(String key) {
        Map<String, Object> attributes = new HashMap<>();
        List<Post> Posts = this.postMapper.findPostsByKey(key);
        // all posts
        attributes.put("posts", Posts);
        // provide a new data transfer object
        attributes.put("postDto", new Post());
        return attributes;
    }

}