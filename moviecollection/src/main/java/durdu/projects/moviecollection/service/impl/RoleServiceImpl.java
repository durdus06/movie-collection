package durdu.projects.moviecollection.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import durdu.projects.moviecollection.model.Role;
import durdu.projects.moviecollection.repository.RoleRepository;
import durdu.projects.moviecollection.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public Optional<Role> findRoleByRoleId(int roleId) {
	 return	roleRepository.findById(roleId);
	}

}
