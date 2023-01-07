package com.techsolutions.gobarber.services;

import com.techsolutions.gobarber.dto.SessionRequestDTO;
import com.techsolutions.gobarber.dto.UserResponseDTO;
import reactor.core.publisher.Mono;

public interface SessionService {
    Mono<UserResponseDTO> createSession(SessionRequestDTO sessionRequestDTO);
}
