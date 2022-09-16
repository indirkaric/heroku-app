package com.indir.heroku.app.logic.service;

import com.indir.heroku.app.domain.dto.CreateUserDto;
import com.indir.heroku.app.domain.dto.UserDto;
import com.indir.heroku.app.domain.entity.User;
import com.indir.heroku.app.domain.repository.UserRepository;
import com.indir.heroku.app.exception.error.BadRequestException;
import com.indir.heroku.app.exception.error.NotFoundException;
import com.indir.heroku.app.exception.error.RestApiError;
import com.indir.heroku.app.logic.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    public List<UserDto> getAllUsers() {
        return userRepository.findAllUsers()
                .stream()
                .map(UserMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public void createUser(CreateUserDto createUserDto) {
        checkIfUserExists(createUserDto.getUsername());
        var user = userRepository.save(UserMapper.INSTANCE.toEntity(createUserDto));
    }

    public void deleteUser(Long id) {
        var user = findById(id);
        user.setActive(false);
        userRepository.save(user);}

    public UserDto findUserById(Long id) {
        return UserMapper.INSTANCE.toDto(findById(id));
    }

    private User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            throw new NotFoundException(RestApiError.USER_NOT_FOUND);
        return user.get();
    }

    private void checkIfUserExists(String username) {
        if (userRepository.findByUsername(username) != null)
            throw new BadRequestException(RestApiError.USER_ALREADY_EXIST);
    }

}