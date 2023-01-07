package com.techsolutions.gobarber.services;

import com.techsolutions.gobarber.dto.SessionRequestDTO;
import com.techsolutions.gobarber.dto.UserResponseDTO;
import com.techsolutions.gobarber.repository.UsersRepository;
import com.techsolutions.gobarber.utils.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService{

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<UserResponseDTO> createSession(SessionRequestDTO sessionRequestDTO) {
        return this.usersRepository
                .findByEmail(sessionRequestDTO.getEmail())
                .filter(user -> passwordEncoder.matches(sessionRequestDTO.getPassword(), user.getPassword()))
                .map(user -> EntityDtoUtil.toDto(user))
                .switchIfEmpty(Mono.error(new Error("Incorrect email/password combination")));
    }
}
