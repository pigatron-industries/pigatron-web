package com.pigatron.web.admin.security;

import com.pigatron.web.security.entity.User;
import com.pigatron.web.security.repository.UserRepository;
import com.pigatron.web.security.service.SecUserDetailsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static com.pigatron.web.security.entity.User.aUser;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SecUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private User existingUser;

    private SecUserDetailsService secUserDetailsService;

    @Before
    public void setup() {
        secUserDetailsService = new SecUserDetailsService(userRepository);
    }

    @Test
    public void whenSave_newUser() {
        User user = new User("username", "password", "ADMIN");

        secUserDetailsService.save(user);

        verify(userRepository).save(user);
        assertThat(user.getPassword()).isNotEqualTo("password");
    }

    @Test
    public void whenSave_passwordNotUpdated() {
        given(userRepository.findById("2")).willReturn(Optional.of(aUser()
                .withId("2")
                .withUsername("username")
                .withPassword("ABCDEF")
                .build()));
        User updatedUser = aUser()
                .withId("2")
                .withUsername("username_changed")
                .withPassword("ABCDEF")
                .build();

        secUserDetailsService.save(updatedUser);

        verify(userRepository).save(updatedUser);
        assertThat(updatedUser.getPassword()).isEqualTo("ABCDEF");
    }

    @Test
    public void whenSave_passwordUpdated() {
        given(userRepository.findById("2")).willReturn(Optional.of(aUser()
                .withId("2")
                .withUsername("username")
                .withPassword("ABCDEF")
                .build()));
        User updatedUser = aUser()
                .withId("2")
                .withUsername("username_changed")
                .withPassword("password_changed")
                .build();

        secUserDetailsService.save(updatedUser);

        verify(userRepository).save(updatedUser);
        assertThat(updatedUser.getPassword()).isNotEqualTo("ABCDEF");
        assertThat(updatedUser.getPassword()).isNotEqualTo("password_changed");
    }

}
