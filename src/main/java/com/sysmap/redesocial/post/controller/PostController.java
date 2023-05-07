package com.sysmap.redesocial.post.controller;

import com.sysmap.redesocial.post.service.PostService;
import com.sysmap.redesocial.post.service.dto.CreatePostRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    @Transactional
    public ResponseEntity createPost(@RequestBody CreatePostRequestDTO postDTO) {
        var post = postService.createPost(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }


    @GetMapping
    public ResponseEntity findAllPosts() {
        var posts = postService.findAllPosts();
        return ResponseEntity.status(HttpStatus.FOUND).body(posts);
    }

    @GetMapping("/postId")
    public ResponseEntity findPostById(@RequestParam UUID postId) {
        var post = postService.findPostById(postId);
        return ResponseEntity.status(HttpStatus.FOUND).body(post);
    }

    @DeleteMapping("/postId")
    @Transactional
    public ResponseEntity deletePost(@RequestParam UUID postId) {
        postService.deletePost(postId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
