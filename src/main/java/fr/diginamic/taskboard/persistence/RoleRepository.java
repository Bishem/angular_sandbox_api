package fr.diginamic.taskboard.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.diginamic.taskboard.util.enums.Authority;
import fr.diginamic.taskboard.util.generics.GenericRepository;
import fr.diginamic.taskboard.util.models.Role;

@Repository
public interface RoleRepository extends GenericRepository<Role> {

	Optional<Role> findByAuthority(Authority authority);
}
