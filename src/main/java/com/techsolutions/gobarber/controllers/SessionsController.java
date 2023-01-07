package com.techsolutions.gobarber.controllers;

import com.techsolutions.gobarber.dto.SessionRequestDTO;
import com.techsolutions.gobarber.dto.UserRequestDTO;
import com.techsolutions.gobarber.dto.UserResponseDTO;
import com.techsolutions.gobarber.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "v1/sessions")
@RequiredArgsConstructor
public class SessionsController {


    private final SessionService sessionService;

    @PostMapping
    public Mono<UserResponseDTO> createSession(@RequestBody Mono<SessionRequestDTO> sessionRequestDTOMono) {

        Mono<UserResponseDTO> userResponseDTOMono = sessionRequestDTOMono.flatMap(this.sessionService::createSession);
        return userResponseDTOMono
                .onErrorResume(e -> {
                    if(e.getMessage().contains("Incorrect email/password combination")){
                        return Mono.error(new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage()));
                    }
                    return Mono.error(RuntimeException::new);
                });
    }
}
