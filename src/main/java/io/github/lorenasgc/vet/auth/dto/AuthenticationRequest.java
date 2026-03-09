package io.github.lorenasgc.vet.auth.dto;

public record AuthenticationRequest(String email,
                                    String password) {
}
