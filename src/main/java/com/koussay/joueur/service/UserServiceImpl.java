package com.koussay.joueur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.koussay.joueur.entities.Role;
import com.koussay.joueur.entities.User;
import com.koussay.joueur.repos.RoleRepository;
import com.koussay.joueur.repos.UserRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override

	public void deleteAllusers() {
		userRep.deleteAll();
		
		
	}
	@Override
	public void deleteAllRoles() {
		roleRep.deleteAll();
		
	}
	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}
	@Override
	public User findUserByUsername(String username) {
		return userRep.findByUsername(username);
	}
	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}
	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		usr.getRoles().add(r);
		return usr;

	}

	

	
}