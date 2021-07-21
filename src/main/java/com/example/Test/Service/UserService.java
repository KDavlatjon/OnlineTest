package com.example.Test.Service;

import com.example.Test.model.Users;
import com.example.Test.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    Save
    public Users add(Users users){
        return userRepository.save(users);
    }

//    Find by id
    public Users getOne(Integer id){
        return  userRepository.findById(id).orElse(null);
    }

//    Find by Name
    public  Users getByPhone(String phone){
        return userRepository.findByPhone(phone).orElse(null);
    }

//    Find All
    public List<Users> getList(){
        return userRepository.findAll();
    }

//    Delete Users
    public void deleteOne(Integer id){
        userRepository.deleteById(id);
    }

//    Update
    public Users update(Integer id, Users users){
        Users users1 = getOne(id);
        users1.setName(users.getName());
        users1.setLastName(users.getLastName());
        users1.setGroupNumber(users.getGroupNumber());
        users1.setPhone(users.getPhone());
        return userRepository.save(users1);
    }

}

