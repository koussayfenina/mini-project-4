package com.koussay.joueur.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koussay.joueur.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
 User findByUsername (String username);
}



