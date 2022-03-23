package com.revanture.chaslsBank;

import com.revanture.chaslsBank.User;
import com.revanture.chaslsBank.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        userRepository = new UserRepository();
    }

    @Test
    public void whenCreateUserIsCalledDoesNotThrowExceptionAndUserIsCreated(){
        User user = new User("Test", "User");

        Assertions.assertDoesNotThrow(() -> userRepository.create(user));
    }

    @Test
    public void whenCallingGetUserByUsernameWithValidUsernameReturnsUserObject(){
        String username = "admin";

        User user = userRepository.getByUsername(username);
        Assertions.assertEquals(username, user.getUsername());
    }
}
