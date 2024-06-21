package com.marco.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marco.prueba.dto.UserDto;
import com.marco.prueba.model.Role;
import com.marco.prueba.model.User;
import com.marco.prueba.repository.RoleRepository;
import com.marco.prueba.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public User registerUser(UserDto userDto){
        User user = userDtoToEntity(userDto);
        if (user == null){
            return null;
        }

        try {
            return userRepository.save(user);
        } catch (Exception e) {
            return null;
        }
        

    }

    private User userDtoToEntity(UserDto userDto){
        if (userDto.getRole_id() == null){
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setBorn_date(userDto.getBorn_date());
        user.setPhone_number(userDto.getPhone_number());
        Optional<Role> role = roleRepository.findById(userDto.getRole_id());

        if (role.isPresent()){
            user.setRole_id(role.get());
        } else  {
            return null;
        }
        return user;
    }

    public User editUser(Long id, UserDto userDto){
        Optional<User> userAux = userRepository.findById(id);
        if (userAux.isPresent()){
            User user = userDtoToEntity(userDto);
            if (user.getRole_id() != null) {
                Optional<Role> role = roleRepository.findById(userDto.getRole_id());
                if (role.isPresent()){
                    user.setRole_id(role.get());
                } else {
                    return null;
                }
            }
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id){
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
