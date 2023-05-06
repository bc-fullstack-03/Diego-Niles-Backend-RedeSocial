package com.sysmap.redesocial.post.data;

import com.sysmap.redesocial.post.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PostRepository extends MongoRepository<Post, UUID> {
}
