package com.utnbuenosaires.backcompubaires.model.service;

import com.utnbuenosaires.backcompubaires.model.dto.ResponseDto;
import com.utnbuenosaires.backcompubaires.model.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserDto> getUsers();

    UserDto getUserById(Long id);

    ResponseDto createUser(UserDto userDto);

    Optional<ResponseEntity<UserDto>> updateUser(Long id, UserDto userDto);

    ResponseDto deleteUser(Long id);

}
