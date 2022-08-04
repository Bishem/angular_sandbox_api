package fr.diginamic.taskboard.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.taskboard.business.UserService;
import fr.diginamic.taskboard.util.beans.UserBean;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public Mono<List<UserBean>> fetchAll() {
		return Mono.just(service.findAll());
	}

	@GetMapping("/{email}")
	public Mono<UserBean> fetch(@PathVariable final String email) {
		return Mono.just(service.find(email));
	}

	@PostMapping
	public Mono<UserBean> create(@RequestBody @Valid final UserBean bean) {
		return Mono.just(service.create(bean));
	}

	@PutMapping
	public Mono<UserBean> update(@RequestBody @Valid final UserBean bean) {
		return Mono.just(service.update(bean));
	}

	@DeleteMapping("/{email}")
	public Mono<Boolean> delete(@PathVariable final String email) {
		return Mono.just(service.delete(email));
	}
}
