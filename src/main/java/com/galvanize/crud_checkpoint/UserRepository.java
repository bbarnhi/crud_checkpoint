package com.galvanize.crud_checkpoint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(User user);

//    @Query(value = "SELECT * FROM user WHERE id = :id", nativeQuery = true)
//    User id(String id); //title gets added to query
//
//    @Query(value = "SELECT * FROM user WHERE id = :id", nativeQuery = true)
//    User findById(String id);
//
////    @Query(value = "UPDATE user SET email = :email, password = :password WHERE id = :id", nativeQuery = true)
////    User patchById(String id, User user);
//
//    @Query(value = "DELETE FROM user WHERE id = :id", nativeQuery = true)
//    User deleteById(String id);

}

/// Code Example -- not mine  --- Requires 3rd class for authenticate to function.
/// repostitory User findByEmail(String email);

//    PostMapping("/authenticate")
//    public Authenticated auth(@RequestBody User auth) {
//        boolean valid = this.repository.findByEmail(auth.getEmail()).getEmail().equals(auth.getEmail());
//        Authenticated output;
//        if (valid) {
//            output = new Authenticated(true);
//            System.out.println("valid");
//            output.setUser(this.repository.findByEmail(auth.getEmail()));
//        } else {
//            output = new Authenticated(false);
//        }
//        return output;
//    }
