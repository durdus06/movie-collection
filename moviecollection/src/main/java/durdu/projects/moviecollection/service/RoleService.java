package durdu.projects.moviecollection.service;

import java.util.Optional;

import durdu.projects.moviecollection.model.Role;


public interface RoleService {
	Optional<Role> findRoleByRoleId(int roleId);

}
