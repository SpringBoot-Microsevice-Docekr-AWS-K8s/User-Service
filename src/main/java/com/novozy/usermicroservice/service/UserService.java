package com.novozy.usermicroservice.service;

import com.novozy.usermicroservice.dto.UserDTO;
import com.novozy.usermicroservice.entity.User;
import com.novozy.usermicroservice.mapper.UserMapper;
import com.novozy.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO sveUser(UserDTO userDTO) {
        User save = userRepository.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(save);
    }

    public List<UserDTO> fetchAllUsers() {
        List<User> all = userRepository.findAll();
        return all.stream().map(UserMapper.INSTANCE::mapUserToUserDTO).collect(Collectors.toList());
    }

    public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
        Optional<User> fetchUser = userRepository.findById(userId);
        return fetchUser.map(user -> new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
