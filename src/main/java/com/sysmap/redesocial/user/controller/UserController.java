package com.sysmap.redesocial.user.controller;

import com.sysmap.redesocial.user.service.dto.CreateUserRequestDTO;
import com.sysmap.redesocial.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity createUser(@RequestBody CreateUserRequestDTO userDTO) {
        var user = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(path = "/userId")
    @Transactional
    public ResponseEntity updateUser(@RequestBody CreateUserRequestDTO userDTO) {
        var user = userService.UpdateUser(userDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @GetMapping
    public ResponseEntity findAllUser() {
        var user = userService.findAllUser();
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @GetMapping("/userId")
    public ResponseEntity findUserById(@RequestParam UUID userId) {
        var user = userService.findAllUser();
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @DeleteMapping("userId")
    @Transactional
    public ResponseEntity deleteUser(@RequestParam UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
