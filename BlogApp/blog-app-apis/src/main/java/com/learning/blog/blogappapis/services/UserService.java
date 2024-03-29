package com.learning.blog.blogappapis.services;

import com.learning.blog.blogappapis.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer Id);
    UserDto getUserByID(Integer id);
    List<UserDto> getAllUsers();
    void deleteUser(Integer id);

}
