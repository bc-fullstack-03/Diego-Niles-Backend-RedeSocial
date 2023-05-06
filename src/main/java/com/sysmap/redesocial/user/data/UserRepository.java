package com.sysmap.redesocial.user.data;

import com.sysmap.redesocial.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {


}
