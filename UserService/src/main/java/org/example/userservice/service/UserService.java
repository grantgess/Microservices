package org.example.userservice.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.userservice.dto.UserDTO;
import org.example.userservice.exceptions.UserNotFoundException;
import org.example.userservice.model.User;
import org.example.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public void save(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
    }
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElseThrow(() -> new UserNotFoundException("User with id = " + id + " not found"));
    }
}
