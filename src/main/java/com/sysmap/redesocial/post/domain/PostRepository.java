package com.sysmap.redesocial.post.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PostRepository extends MongoRepository<Post, UUID> {
}
