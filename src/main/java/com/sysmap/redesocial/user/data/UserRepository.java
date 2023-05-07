package com.sysmap.redesocial.user.data;

import com.sysmap.redesocial.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

    User findByEmail(String email);

    boolean findUserByEmail(boolean empty);
}
