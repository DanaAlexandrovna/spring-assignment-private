package ro.sda.javaro35.finalProject.repository;

import ro.sda.javaro35.finalProject.dto.user.UserDto;

import java.util.List;

public interface UserServiceRepository {

    List<UserDto> findAll();

    UserDto findById(String id);
    UserDto save();
}
