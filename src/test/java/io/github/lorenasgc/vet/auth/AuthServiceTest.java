package io.github.lorenasgc.vet.auth;

import io.github.lorenasgc.vet.auth.dto.AuthenticationResponse;
import io.github.lorenasgc.vet.auth.dto.RegisterRequest;
import io.github.lorenasgc.vet.model.User;
import io.github.lorenasgc.vet.repository.UserRepository;
import io.github.lorenasgc.vet.security.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository repository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthService authService;

    @Test
    void register_ShouldSaveUserAndReturnToken() {
        RegisterRequest request = new RegisterRequest(
                "Lorena", "Gonzalez", "lorena@test.com", "password123"
        );

        when(passwordEncoder.encode("password123")).thenReturn("encrypted-password");
        when(repository.save(any(User.class))).thenReturn(new User());
        when(jwtService.generateToken(any(User.class))).thenReturn("mocked-jwt-token");

        AuthenticationResponse response = authService.register(request);

        assertNotNull(response);
        assertEquals("mocked-jwt-token", response.token());
        verify(passwordEncoder).encode("password123");
        verify(repository).save(any(User.class));
        verify(jwtService).generateToken(any(User.class));
    }
}