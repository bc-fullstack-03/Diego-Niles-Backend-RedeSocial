package com.sysmap.redesocial.post.service;

import com.sysmap.redesocial.comments.domain.Comments;
import com.sysmap.redesocial.like.domain.Like;
import com.sysmap.redesocial.post.data.PostRepository;
import com.sysmap.redesocial.post.domain.Post;
import com.sysmap.redesocial.post.service.dto.CreatePostRequestDTO;
import com.sysmap.redesocial.post.service.dto.SearchPostResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(CreatePostRequestDTO postDTO) {
        var post = postRepository.insert(new Post(postDTO));
        return post;
    }

    public List<SearchPostResponseDTO> findAllPosts() {
        List<Post> retreatPostsList = postRepository.findAll();
        List<SearchPostResponseDTO> postDTO = new ArrayList<>();
        for (Post post : retreatPostsList) {
            postDTO.add(new SearchPostResponseDTO(post));
        }
        return postDTO;
    }

    public SearchPostResponseDTO findPostById(@PathVariable UUID postId) {
        Post post = postRepository.findById(postId).get();
        return new SearchPostResponseDTO(post);
    }

    public Post createLikePost(@PathVariable UUID postId) {
        Post post = postRepository.findById(postId).get();
        Like like = new Like(post.getUserId());
        post.getPostLike().add(like);
        return post;

    }

    public Post createCommentPost(@PathVariable UUID postId, String comment) {
        Post post = postRepository.findById(postId).get();
        Comments comments = new Comments(post.getUserId(), comment);
        post.getComment().add(comments);
        return post;

    }

    public void deletePost(UUID postId) {
        postRepository.deleteById(postId);
    }
}
