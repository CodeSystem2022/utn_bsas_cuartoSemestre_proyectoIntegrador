package com.utnbuenosaires.backcompubaires.controller;

import com.utnbuenosaires.backcompubaires.model.dto.ResponseDto;
import com.utnbuenosaires.backcompubaires.model.dto.UserDto;
import com.utnbuenosaires.backcompubaires.model.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public UserDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/createUser")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public Optional<ResponseEntity<UserDto>> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto){
        return userService.updateUser(id,userDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

}
