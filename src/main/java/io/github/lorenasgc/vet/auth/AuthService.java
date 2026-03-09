package io.github.lorenasgc.vet.auth;

import io.github.lorenasgc.vet.auth.dto.AuthenticationRequest;
import io.github.lorenasgc.vet.auth.dto.AuthenticationResponse;
import io.github.lorenasgc.vet.auth.dto.RegisterRequest;
import io.github.lorenasgc.vet.exception.ResourceNotFoundException;
import io.github.lorenasgc.vet.model.Role;
import io.github.lorenasgc.vet.model.User;
import io.github.lorenasgc.vet.repository.UserRepository;
import io.github.lorenasgc.vet.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                // For testing purposes, the ADMIN role is assigned to anyone who registers.
                // In a production environment, this would be Role.CLIENT, and ADMINs would be created differently.
                .role(Role.ADMIN)
                .build();

        repository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        var user = repository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + request.email()));

        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }
}
