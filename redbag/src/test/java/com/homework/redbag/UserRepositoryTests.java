package com.homework.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void listAll(){
        List<User> list = repository.findAll();
        for (User user:list){
            System.out.println(user);
        }
        return;
    }

    @Test
    public void save(){
        String username = "李王";
        String password = "1010@qq.com";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        repository.save(user);
        return;

    }

    @Test
    public void deleteById(){
        String id = "4028098175fe84be0175fe84c8a40000";
        repository.deleteById(id);
        return;
    }

    @Test
    public void update(){
        String username = "王冰";
        String email = "1010@qq.com";
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword("123456");
        user.setId("s01");
        repository.save(user);
        return;
    }

    @Test
    public void getById(){
        String id = "s01";
        System.out.println(repository.findById(id));
        return;
    }


}
