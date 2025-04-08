package org.example.exreposeitory.Service;

import lombok.AllArgsConstructor;
import org.example.exreposeitory.Model.User;
import org.example.exreposeitory.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User>allUser(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id , User user){
        User oldUser = userRepository.geveTheId(id);
        if (oldUser==null){
            return false;
        }

        oldUser.setName(user.getName());
        oldUser.setUserName(user.getUserName());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());

        userRepository.save(oldUser);
        return true;
    }

    public Boolean deleteUser(Integer id ){
        User user = userRepository.geveTheId(id);
        if (user == null){
            return false;
        }

        user.setName(user.getName());
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setRole(user.getRole());
        user.setAge(user.getAge());

        userRepository.delete(user);
        return true;
    }

    public  User checkUserNameAndPassword(String userName, String password){
      User user = userRepository.findUserByUserNameAndPassword(userName, password);

      return user;

    }

    public User getEmail(String email){
        return userRepository.findUserByEmail(email);

    }

    public List<User>getRole(String role){
    return userRepository.findUserByRole(role);
    }

    public List<User>getAge(Integer age){
    return userRepository.userAge(age);
    }


}
