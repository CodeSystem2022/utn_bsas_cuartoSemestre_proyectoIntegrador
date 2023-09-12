package com.utnbuenosaires.backcompubaires.model.service.impl;

import com.utnbuenosaires.backcompubaires.model.dto.ResponseDto;
import com.utnbuenosaires.backcompubaires.model.dto.UserDto;
import com.utnbuenosaires.backcompubaires.model.entity.User;
import com.utnbuenosaires.backcompubaires.model.repository.IUserRepository;
import com.utnbuenosaires.backcompubaires.model.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getUsers() {
        ModelMapper mapper = new ModelMapper();
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();

        users.stream()
                .forEach(u-> usersDto.add(mapper.map(u,UserDto.class)));

        return usersDto;
    }

    public UserDto getUserById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Optional<User> user = userRepository.findById(id);
        return mapper.map(user, UserDto.class);
    }

    @Override
    public ResponseDto createUser(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto,User.class);

        userRepository.save(user);

        return new ResponseDto("User Succesfully Created!!!");
    }

    @Override
    public java.util.Optional<ResponseEntity<UserDto>> updateUser(Long id, UserDto userDto) {
        ModelMapper mapper = new ModelMapper();

        return userRepository.findById(id)
                .map(u->{
                    u.setDni(userDto.getDni());
                    u.setCuil(userDto.getCuil());
                    u.setName(userDto.getName());
                    u.setLastName(userDto.getLastName());
                    u.setTelephone(userDto.getTelephone());
                    u.setEmail(userDto.getEmail());
                    u.setNeighborhood(userDto.getNeighborhood());
                    u.setProvince(userDto.getProvince());
                    u.setCountry(userDto.getCountry());

                    User updatedUser = userRepository.save(u);
                    UserDto updatedUserDto = mapper.map(updatedUser,UserDto.class);
                    return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
                });
    }


    @Override
    public ResponseDto deleteUser(Long id) {
        userRepository.deleteById(id);
        return new ResponseDto("User Succesfully Deleted!!!");
    }
}
