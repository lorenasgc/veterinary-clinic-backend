package io.github.lorenasgc.vet.mapper;

import io.github.lorenasgc.vet.dto.request.UpdateUserRequest;
import io.github.lorenasgc.vet.dto.response.UserResponse;
import io.github.lorenasgc.vet.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
    void updateUserFromRequest(UpdateUserRequest request, @MappingTarget User user);
}
