package com.sysmap.redesocial.user.service;

import com.sysmap.redesocial.user.domain.CreateUserDTO;
import com.sysmap.redesocial.user.domain.User;
import com.sysmap.redesocial.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDTO userDTO){
        User user = new User(userDTO.name());
        return userRepository.insert(user);
    }


    public void deleteUser(@PathVariable UUID userId){
        userRepository.deleteById(userId);
    }

}
