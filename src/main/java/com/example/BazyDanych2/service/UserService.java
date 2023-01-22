package com.example.BazyDanych2.service;

import com.example.BazyDanych2.exception.RecordNotFoundException;
import com.example.BazyDanych2.model.User;
import com.example.BazyDanych2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


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
        try{
            return userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(USER_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public User getUserByWorkName(String workName){
        try{
            return userRepository.findByWorkName(workName).orElseThrow(() -> new RecordNotFoundException(USER_NOT_FOUND));
        }catch(RecordNotFoundException e){
            throw new RuntimeException(e);
        }
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
