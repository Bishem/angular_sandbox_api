package fr.diginamic.taskboard.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.taskboard.business.UserService;
import fr.diginamic.taskboard.util.beans.UserBean;
import fr.diginamic.taskboard.util.generics.GenericController;
import fr.diginamic.taskboard.util.models.User;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("http://localhost:4200")
public class UserController extends GenericController<User, UserBean> {

//	/**
//	 * this field exists solely to prevent casting in redefined methods
//	 */
//	private final UserService userService;

	protected UserController(final UserService service) {
		super(service);
//		userService = service;
	}

//	@GetMapping("/{email}")
//	public Mono<UserBean> fetchEmail(@PathVariable final String email) {
//		return Mono.just(userService.findEmail(email));
//	}
//
//	@DeleteMapping("/{email}")
//	public Mono<Boolean> deleteEmail(@PathVariable final String email) {
//		return Mono.just(userService.deleteEmail(email));
//	}
}
