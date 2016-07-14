package org.spartan.service;

import java.util.List;

import org.spartan.dao.RoleRepository;
import org.spartan.dao.UserRepository;
import org.spartan.entites.Role;
import org.spartan.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured(value={"ROLE_ADMIN"})
public class UserRestService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@RequestMapping(value="/addUser")
	public User save(User user){
		return userRepository.save(user);
	}
	@RequestMapping(value="/findUsers")
	public List<User> findUsers(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/addRole")
	public Role save(Role role){
		return roleRepository.save(role);
	}
	@RequestMapping(value="/findRoles")
	public List<Role> findRoles(){
		return roleRepository.findAll();
	}
	@RequestMapping(value="/addRoleToUser")
	public User addRoleToUser(String username, String role) {
		User user =userRepository.findOne(username);
		Role role2=roleRepository.findOne(role);
		user.getRoles().add(role2);
		userRepository.save(user);
		return user;
		
		
	}
}
