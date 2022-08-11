package fr.diginamic.taskboard.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.taskboard.business.RoleService;
import fr.diginamic.taskboard.util.generics.GenericController;
import fr.diginamic.taskboard.util.models.Role;

@RestController
@RequestMapping("/api/role")
@CrossOrigin("http://localhost:4200")
public class RoleController extends GenericController<Role> {

	protected RoleController(final RoleService service) {
		super(service);
	}
}
