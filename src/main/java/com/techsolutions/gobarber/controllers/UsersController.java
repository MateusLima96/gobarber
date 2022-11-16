package com.techsolutions.gobarber.controllers;

import com.techsolutions.gobarber.dto.AppointmentResponseDTO;
import com.techsolutions.gobarber.dto.UserRequestDTO;
import com.techsolutions.gobarber.dto.UserResponseDTO;
import com.techsolutions.gobarber.services.AppointmentService;
import com.techsolutions.gobarber.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "v1/users")
@RequiredArgsConstructor
public class UsersController {


    private final UserService userService;

    @PostMapping
    public Mono<UserResponseDTO> createUser(@RequestBody Mono<UserRequestDTO> userRequestDto) {

        Mono<UserResponseDTO> userResponseDTOMono = userRequestDto.flatMap(this.userService::createUser);
        return userResponseDTOMono
                .onErrorResume(e -> {
                    if(e.getMessage().contains("Email address already used")){
                        return Mono.error(new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage()));
                    }
                    return Mono.error(RuntimeException::new);
                });
    }

    @GetMapping
    public Flux<UserResponseDTO> getUsers() {
            return userService.getUsers();
    }

}
