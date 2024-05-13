package com.koussay.joueur.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koussay.joueur.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
