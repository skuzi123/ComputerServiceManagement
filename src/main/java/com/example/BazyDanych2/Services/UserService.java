package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.User;
import com.example.BazyDanych2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static final String USER_NOT_FOUND = "User with this workName doesn't exist!!!";
    private UserRepository userRepository;
    @Autowired
    public UserService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    public User getUserByWorkName(String workName){
        return userRepository.findByWorkName(workName)
                .orElse(null);
    }


    public User createUser(User user){
        return userRepository.saveAndFlush(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(Long id){
        User userToDelete = getUserById(id);
        userRepository.delete(userToDelete);
        return "User with id: " + id + " was deleted!";
    }
}
