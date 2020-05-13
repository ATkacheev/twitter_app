package com.example.letscode.demoletscode;

import com.example.letscode.demoletscode.domain.Role;
import com.example.letscode.demoletscode.domain.User;
import com.example.letscode.demoletscode.repository.UserRepo;
import com.example.letscode.demoletscode.service.MailSender;
import com.example.letscode.demoletscode.service.UserService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private MailSender mailSender;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void addUser(){
        User user = new User();
        user.setEmail("aaa@aaa.ru");
        userService.addUser(user);
        boolean b = userService.addUser(user);

        Assert.assertTrue(b);
        Assert.assertNotNull(user.getActivationCode());
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));

        Mockito.verify(userRepo, Mockito.times(2)).save(user);
        Mockito.verify(mailSender, Mockito.times(2)).send(
                ArgumentMatchers.eq(user.getEmail()),
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString()
        );
    }

    @Test
    public void addUserFailTest(){
        User user = new User();
        user.setUsername("kevin");
        Mockito.doReturn(new User())
                .when(userRepo)
                .findByUsername("kevin");
        boolean b = userService.addUser(user);

        Assert.assertFalse(b);

        Mockito.verify(userRepo, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
        Mockito.verify(mailSender, Mockito.times(0)).send(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString()
        );
    }

    @Test
    public void activateUser(){
        User toBeReturned = new User();
        toBeReturned.setActivationCode("bingo!");
        Mockito.doReturn(toBeReturned)
                .when(userRepo)
                .findByActivationCode("activate");
        boolean activate = userService.activateUser("activate");
        Assert.assertTrue(activate);
        Assert.assertNull(toBeReturned.getActivationCode());

        Mockito.verify(userRepo, Mockito.times(1)).save(toBeReturned);
    }

    @Test
    public void activateUserFailTest(){
        boolean activate = userService.activateUser("activate me");
        Assert.assertFalse(activate);
        Mockito.verify(userRepo, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
    }

    @Test(expected = ArithmeticException.class)
    public void error(){
        int i = 0;
        int n = 1/i;
    }

}
