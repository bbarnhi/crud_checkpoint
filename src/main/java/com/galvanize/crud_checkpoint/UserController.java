package com.galvanize.crud_checkpoint;

import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) { this.repository = repository; };

    @GetMapping("/user")
    public Iterable<User> getAll(){
        //System.out.println("Received GET request");
        return this.repository.findAll();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user){
        return this.repository.save(user);
    }

    @GetMapping("/user/{id}")
    public Optional<User> getId(@PathVariable Long id){
        Optional<User> temp = this.repository.findById(id);
        return this.repository.findById(id);
    }

//    @PatchMapping("/user/{id}")
//    public User patchById(@PathVariable Long id, @RequestBody User user){
//        return this.repository.save(id, user);
//    }
    @PatchMapping("/user/{id}")
    public User patch(@PathVariable Long id, @RequestBody User updates) {
    Optional<User> current = this.repository.findById(id);
        if (updates.getEmail() != null) {
            current.get().setEmail(updates.getEmail());
        }
        if (updates.getPassword() != null) {
            current.get().setPassword(updates.getPassword());
    }
    return this.repository.save(current.get());
}

    @DeleteMapping("/user/{id}")
    public void deleteId(@PathVariable Long id){
        this.repository.deleteById(id);
    }

    @PostMapping("/user/authenticate")
    public void authenticate(@RequestBody User authenticate){
        Optional<User> current = this.repository.findByEmail(authenticate);
        current.get().setEmail(authenticate.getEmail());
        current.get().setPassword(authenticate.getPassword());
        System.out.println(current);


        //return authenticate;
    }
}
