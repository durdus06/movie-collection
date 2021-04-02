package durdu.projects.moviecollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import durdu.projects.moviecollection.model.Role;

public interface RoleRepository  extends JpaRepository<Role, Integer> {
	
	

}
