package com.utnbuenosaires.backcompubaires.model.service;

import com.utnbuenosaires.backcompubaires.model.dto.ResponseDto;
import com.utnbuenosaires.backcompubaires.model.dto.UsuarioDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<UsuarioDto> getUsers();

    UsuarioDto getUserById(Long id);

    ResponseDto createUser(UsuarioDto usuarioDto);

    Optional<ResponseEntity<UsuarioDto>> updateUser(Long id, @Valid UsuarioDto userDto);

    ResponseDto deleteUser(Long id);

}
