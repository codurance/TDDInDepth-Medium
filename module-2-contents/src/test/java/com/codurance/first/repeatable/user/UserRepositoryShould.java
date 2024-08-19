package com.codurance.first.repeatable.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserRepositoryShould {
    private UserGateway usersDataBase;
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        usersDataBase = mock(UserGateway.class);
        userRepository = new UserRepository(usersDataBase);
    }

    @Test
    public void storeNewUserInTheDatabase() {
        when(usersDataBase.findByUsername("cod1")).thenReturn(null);

        userRepository.save(new User("cod1"));

        verify(usersDataBase).insert("cod1");
   }

    @Test
    public void notStoreAUserInTheDatabaseTwice() {
        User user = new User("cod1");

        when(usersDataBase.findByUsername("cod1")).thenReturn(user);

        userRepository.save(user);

        verify(usersDataBase, times(0)).insert("cod1");
   }
}
