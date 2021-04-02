package durdu.projects.moviecollection.service.impl;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import durdu.projects.moviecollection.model.CustomUserDetails;
import durdu.projects.moviecollection.model.Role;
import durdu.projects.moviecollection.model.User;
import durdu.projects.moviecollection.repository.RoleRepository;
import durdu.projects.moviecollection.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = findUserByEmail(email);
		
		if(!user.isPresent() ) {
			throw new UsernameNotFoundException("This user does not exist.");
		}
		return new CustomUserDetails(user.get());
	}
	
	public void addUser(User user) {
		
		//Encode password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		//Set the role "USER"
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		
		userRepository.save(user);
		
	}
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

}
