package com.pigatron.admin.security;

import com.pigatron.admin.security.entity.User;
import com.pigatron.admin.security.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.pigatron.admin.security.entity.User.aUser;
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
        given(userRepository.findOne("2")).willReturn(aUser()
                .withId("2")
                .withUsername("username")
                .withPassword("ABCDEF")
                .build());
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
        given(userRepository.findOne("2")).willReturn(aUser()
                .withId("2")
                .withUsername("username")
                .withPassword("ABCDEF")
                .build());
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
