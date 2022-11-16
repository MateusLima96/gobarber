package com.techsolutions.gobarber.services;

import com.techsolutions.gobarber.dto.UserRequestDTO;
import com.techsolutions.gobarber.dto.UserResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

   Mono<UserResponseDTO> createUser(UserRequestDTO userRequestDTO);

    Flux<UserResponseDTO> getUsers();
}
