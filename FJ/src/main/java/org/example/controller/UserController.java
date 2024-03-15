package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.UserModelDTO;
import org.example.models.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public ResponseEntity<UserModelDTO> getUserController(@RequestParam String name) {
        return ResponseEntity.ok(userService.getUser(name));
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserModelDTO> addNewUserController(@Valid @RequestBody UserModelDTO userModelDTO) {

        return ResponseEntity.ok(userService.addNewUser(userModelDTO));
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserModelDTO> updateUserController(@PathVariable int id, @RequestBody UserModelDTO userModelDTO) {

        return ResponseEntity.ok(userService.updateUser(userModelDTO, id));
    }

    @DeleteMapping("/deleteUser/{firstName}")
    public ResponseEntity<?> deleteUserController(@PathVariable int id) {

        userService.deleteUser(id);
        return ResponseEntity.ok("DeleteOK");
    }
}
