package com.techsolutions.gobarber.services;

import com.techsolutions.gobarber.dto.UserRequestDTO;
import com.techsolutions.gobarber.dto.UserResponseDTO;
import com.techsolutions.gobarber.repository.UsersRepository;
import com.techsolutions.gobarber.utils.EntityDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public Mono<UserResponseDTO> createUser(UserRequestDTO userRequestDTO) {
        return this.usersRepository
                .findByEmail(userRequestDTO.getEmail())
                .flatMap(usr -> Mono.<UserResponseDTO>error(new Error("Email address already used")))
                .switchIfEmpty(Mono.just(
                                EntityDtoUtil.toEntity(userRequestDTO, passwordEncoder
                                        .encode(userRequestDTO.getPassword()))
                        ).flatMap(this.usersRepository::save)
                        .map(usr -> EntityDtoUtil.toDto(usr, usr.getId())));
    }

    @Override
    public Flux<UserResponseDTO> getUsers() {
        return this.usersRepository.findAll()
                .map(EntityDtoUtil::toDto);
    }
}
