package com.marco.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marco.prueba.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
