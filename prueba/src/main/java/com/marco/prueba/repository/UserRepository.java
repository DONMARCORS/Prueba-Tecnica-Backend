package com.marco.prueba.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.marco.prueba.model.Role;
import com.marco.prueba.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    //Optional<User> findByRole(Role role);
}
