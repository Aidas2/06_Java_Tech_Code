package lt.akademijait.warehouse.roles.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.akademijait.warehouse.users.models.Role;
import lt.akademijait.warehouse.users.models.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    //Originalus metodas
	Optional<Role> findByName(RoleName roleName);

	// int countAllRoles();

	// Abejotinas metodas - ištrinti reikės
	// Role findRoleByString(String searchString);

	Boolean existsByName(RoleName roleName);
    //Mano metodas
	//Role findByName(RoleName roleName);
}