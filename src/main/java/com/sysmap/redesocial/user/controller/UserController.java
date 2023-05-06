package com.sysmap.redesocial.user.controller;

import com.sysmap.redesocial.user.domain.CreateUserDTO;
import com.sysmap.redesocial.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity createUser(@RequestBody CreateUserDTO userDTO) {
        var user = userService.createUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @PutMapping(path = "/userId")
    @Transactional
    public ResponseEntity updateUser(@RequestBody CreateUserDTO userDTO) {
        var user = userService.UpdateUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity findAllUser() {
        var user = userService.findAllUser();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/userId")
    public ResponseEntity findUserById(@RequestParam UUID userId) {
        var user = userService.findAllUser();
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("userId")
    @Transactional
    public ResponseEntity deleteUser(@RequestParam UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.notFound().build();
    }


}
