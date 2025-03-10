package org.example.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orderservice.dto.UserDTO;
import org.example.orderservice.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceClient {

    private final RestTemplate restTemplate;

    @Value("${userHostURL}")
    private String userHostUrl;

    public UserDTO getUser(Long userId) {
        try {
            return restTemplate.getForObject(userHostUrl + "/users/" + userId, UserDTO.class);
        } catch (HttpClientErrorException ex) {
            throw new UserNotFoundException("User with id = " + userId + " not found");
        }
    }

}
