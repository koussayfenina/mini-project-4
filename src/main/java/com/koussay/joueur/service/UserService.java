package com.koussay.joueur.service;

import com.koussay.joueur.entities.Role;
import com.koussay.joueur.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	
	User addRoleToUser(String username, String rolename);


}
