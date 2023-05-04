package com.sysmap.redesocial.user.service;

import com.sysmap.redesocial.user.domain.CreateUserDTO;
import com.sysmap.redesocial.user.domain.User;
import com.sysmap.redesocial.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDTO userDTO) {
        User user = new User(userDTO.getUserName(), userDTO.getEmail(), userDTO.getPassword());
        return userRepository.insert(user);
    }


    public void deleteUser(@PathVariable UUID userId) {
        userRepository.deleteById(userId);
    }

}
