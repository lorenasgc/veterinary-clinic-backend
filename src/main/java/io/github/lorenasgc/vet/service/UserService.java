package io.github.lorenasgc.vet.service;

import io.github.lorenasgc.vet.dto.request.UpdateUserRequest;
import io.github.lorenasgc.vet.dto.response.UserResponse;
import io.github.lorenasgc.vet.exception.ResourceNotFoundException;
import io.github.lorenasgc.vet.mapper.UserMapper;
import io.github.lorenasgc.vet.model.User;
import io.github.lorenasgc.vet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponse findUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserResponse)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID "+ id));
    }

    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
        if (!existingUser.getEmail().equals(request.email()) && userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email address is already in use by another user.");
        }
        userMapper.updateUserFromRequest(request, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toUserResponse(updatedUser);
    }
}
