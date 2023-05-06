package com.sysmap.redesocial.post.service;

import com.sysmap.redesocial.post.data.PostRepository;
import com.sysmap.redesocial.post.domain.Post;
import com.sysmap.redesocial.post.service.dto.CreatePostDTO;
import com.sysmap.redesocial.post.service.dto.SearchPostDTO;
import com.sysmap.redesocial.user.domain.User;
import com.sysmap.redesocial.user.service.dto.FindUserDTO;
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

    public Post createPost(CreatePostDTO postDTO) {
        var post = postRepository.insert(new Post(postDTO));
        return post;
    }

    public List<SearchPostDTO> findAllPosts() {
        List<Post> retreatPostsList = postRepository.findAll();
        List<SearchPostDTO> postDTO = new ArrayList<>();
        for (Post post : retreatPostsList) {
            postDTO.add(new SearchPostDTO(post));
        }
        return postDTO;
    }

    public SearchPostDTO findPostById(@PathVariable UUID userId) {
        Post post = postRepository.findById(userId).get();
        return new SearchPostDTO(post);
    }

    public void deletePost(UUID postId) {
        postRepository.deleteById(postId);
    }
}
