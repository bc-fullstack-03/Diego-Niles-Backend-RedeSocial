package com.sysmap.redesocial.user.service;

import com.sysmap.redesocial.user.service.dto.CreateUserRequestDTO;
import com.sysmap.redesocial.user.service.dto.FindUserResponseDTO;
import com.sysmap.redesocial.user.domain.User;
import com.sysmap.redesocial.user.data.UserRepository;
import com.sysmap.redesocial.user.service.fileUpload.IFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IFileUploadService fileUploadService;

    public User createUser(CreateUserRequestDTO userDTO) {
        User user = new User(userDTO.userName(), userDTO.email(), userDTO.password(), userDTO.uriProfilePhoto());

        if (!userRepository.findUserByEmail(userDTO.email().isEmpty())) {
            return null;
        }

        var hash = passwordEncoder.encode(userDTO.password());

        user.setPassword(hash);

        return userRepository.save(user);
    }

    public User UpdateUser(CreateUserRequestDTO userDTO) {
        User user = new User(userDTO.userName(), userDTO.email(), userDTO.password(), userDTO.uriProfilePhoto());
        return userRepository.save(user);
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

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    public User addFriend(@PathVariable UUID userId) {
        User user = userRepository.findById(userId).get();
        user.getFriends().add(user);
        return user;
    }

    public User deleteFriend(@PathVariable UUID userId) {
        User user = userRepository.findById(userId).get();
        user.getFriends().remove(user);
        return user;
    }

    public void deleteUser(@PathVariable UUID userId) {
        userRepository.deleteById(userId);
    }

    public void uploadProfilePhoto(MultipartFile photo) throws Exception {
        var user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        var photoUri = "";

        try {
            var fileName = user.getUserId() + "." + photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1);

            photoUri = fileUploadService.upload(photo, fileName);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        user.setUriProfilePhoto(photoUri);
        userRepository.save(user);
    }

}
