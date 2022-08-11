package fr.diginamic.taskboard.business;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.diginamic.taskboard.persistence.RoleRepository;
import fr.diginamic.taskboard.util.generics.GenericService;
import fr.diginamic.taskboard.util.models.Role;

@Service
public class RoleService extends GenericService<Role> {

	protected RoleService(
			final RoleRepository repository,
			final ModelMapper mapper) {

		super(repository, Role.class, mapper);
	}
}
