package org.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DBforUserTest {

    @Test
    public void saveUser() {
        User user = new User();
        user.setName("Marco");
        user.setFilms("XXX");
        user.setGrade(9.35);
        List<User> users = DBforUser.saveUser(user);
        assertNotNull(users);
        assertFalse(users.isEmpty());
        User savedUser = users.get(0);
        assertEquals(user.getName(),savedUser.getName());
        assertEquals(user.getGrade(),savedUser.getGrade(),0.001);
        assertEquals(user.getFilms(),savedUser.getFilms());
    }
}