package com.sysmap.redesocial.user.service;

import com.sysmap.redesocial.user.service.dto.CreateUserDTO;
import com.sysmap.redesocial.user.service.dto.FindUserDTO;
import com.sysmap.redesocial.user.domain.User;
import com.sysmap.redesocial.user.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDTO userDTO) {
        User user = new User(userDTO.getUserName(), userDTO.email(), userDTO.getPassword(), userDTO.uriProfilePhoto());
        return userRepository.insert(user);
    }

    public User UpdateUser(CreateUserDTO userDTO) {
        User user = new User(userDTO.getUserName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.uriProfilePhoto());
        return userRepository.insert(user);
    }

    public List<FindUserDTO> findAllUser() {
        List<User> retreatUsersList = userRepository.findAll();
        List<FindUserDTO> userDTO = new ArrayList<>();
        for (User user : retreatUsersList) {
            userDTO.add(new FindUserDTO(user));
        }
        return userDTO;
    }

    public FindUserDTO findUserById(@PathVariable UUID userId) {
        User user = userRepository.findById(userId).get();
        return new FindUserDTO(user);
    }


    public void deleteUser(@PathVariable UUID userId) {
        userRepository.deleteById(userId);
    }

}
