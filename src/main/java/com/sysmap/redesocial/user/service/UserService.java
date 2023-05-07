package com.sysmap.redesocial.user.service;

import com.sysmap.redesocial.user.service.dto.CreateUserRequestDTO;
import com.sysmap.redesocial.user.service.dto.FindUserResponseDTO;
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

    public User createUser(CreateUserRequestDTO userDTO) {
        User user = new User(userDTO.userName(), userDTO.email(), userDTO.password(), userDTO.uriProfilePhoto());
        return userRepository.insert(user);
    }

    public User UpdateUser(CreateUserRequestDTO userDTO) {
        User user = new User(userDTO.userName(), userDTO.email(), userDTO.password(), userDTO.uriProfilePhoto());
        return userRepository.insert(user);
    }

    public List<FindUserResponseDTO> findAllUser() {
        List<User> retreatUsersList = userRepository.findAll();
        List<FindUserResponseDTO> userDTO = new ArrayList<>();
        for (User user : retreatUsersList) {
            userDTO.add(new FindUserResponseDTO(user));
        }
        return userDTO;
    }

    public FindUserResponseDTO findUserById(@PathVariable UUID userId) {
        User user = userRepository.findById(userId).get();
        return new FindUserResponseDTO(user);
    }

    public FindUserResponseDTO findUserByEmail(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        return new FindUserResponseDTO(user);
    }

    public User getUser(String email){
        return userRepository.findByEmail(email);
    }


    public void deleteUser(@PathVariable UUID userId) {
        userRepository.deleteById(userId);
    }

}
