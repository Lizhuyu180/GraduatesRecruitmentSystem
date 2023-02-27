package com.web.recruit.mapper;

import com.web.recruit.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PostMapper {
    void save(Post post);

    void delete(Integer postId);

    void update(Post post);

    Post find(Integer postId);

    List<Post> findAll();

    List<Post> findPostsByKey(String keyword);


}
