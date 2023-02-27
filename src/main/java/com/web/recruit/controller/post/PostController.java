package com.web.recruit.controller.post;

import com.web.recruit.controller.BaseController;
import com.web.recruit.entity.Post;
import com.web.recruit.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/post")
public class PostController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public String toPosts() {
        return "user/post";

    }

    /*
     * Create a new post
     */
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public String createPost(Model model, @Valid @ModelAttribute("postDto") Post post) {
        logger.info("Creating post >> " + post);
        this.postService.createPost(post);
        return "user/post";
    }
//
//    /*
//     * Delete a post
//     */
//    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.DELETE)
//    public String deletePost(@PathVariable("postId") Integer postId) {
//        logger.info("Deleting post id:" + postId);
//        this.postService.deletePost(postId);
//        return "user/posts";
//    }
//
//    /*
//     * Update a post
//     */
//    @RequestMapping(value = "/posts", method = RequestMethod.PUT)
//    public String updatePost(@Valid @ModelAttribute("postDto") Post post) {
//        logger.info("Updating post >> " + post);
//        this.postService.updatePost(post);
//        return "user/posts";
//    }
//
//    /*
//     * List all posts
//     */
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String listAllPosts(Model model) {
        logger.info("Listing all posts...");
        Map<String, Object> attributes = this.postService.findAllPosts();
        model.addAllAttributes(attributes);
        return "user/post";
    }
//
//    /*
//     * Display post details
//     */
    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
    public String displayPostDetails(Model model, @PathVariable("postId") Integer postId) {
        logger.info("Displaying post details >> postId: " + postId);
        Map<String, Object> attributes = this.postService.findPost(postId);
        model.addAllAttributes(attributes);
        return "user/post_detail";
    }

    @RequestMapping(value = "/searchByKey", method = RequestMethod.GET)
    public String searchPostByKey(Model model,@RequestParam("keyword") String keyword) {
        Map<String, Object> attributes = this.postService.findPostByKey(keyword);
        model.addAllAttributes(attributes);
        logger.info("根据keyword查找...");
        return "user/post";
    }


}
