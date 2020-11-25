package com.homework.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/list")
    public List<User> listAll(){
        return repository.findAll();
    }

    @GetMapping("/find/{id}")
    public User getById(@PathVariable("id") String id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/save")
    public User save(@RequestParam("id") String id,@RequestParam("username") String username){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return repository.save(user);
    }

    @PutMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id){
        repository.deleteById(id);
        return;
    }

    @PostMapping("update/{id}")
    public User updateById(@RequestParam("id") String id,@RequestParam("username") String username){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return repository.save(user);
    }


}
