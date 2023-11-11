package com.novozy.usermicroservice.mapper;

import com.novozy.usermicroservice.dto.UserDTO;
import com.novozy.usermicroservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser (UserDTO userDTO);
    UserDTO mapUserToUserDTO (User user);

}
