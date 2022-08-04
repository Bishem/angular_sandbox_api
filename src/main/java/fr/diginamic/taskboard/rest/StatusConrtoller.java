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

import fr.diginamic.taskboard.business.StatusService;
import fr.diginamic.taskboard.util.beans.StatusBean;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/status")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusConrtoller {

	@Autowired
	private StatusService service;

	@GetMapping
	public Mono<List<StatusBean>> fetchAll() {
		return Mono.just(service.findAll());
	}

	@GetMapping("/{id}")
	public Mono<StatusBean> fetch(@PathVariable final Integer id) {
		return Mono.just(service.find(id));
	}

	@PostMapping
	public Mono<StatusBean> create(@RequestBody @Valid final StatusBean bean) {
		return Mono.just(service.create(bean));
	}

	@PutMapping
	public Mono<StatusBean> update(@RequestBody @Valid final StatusBean bean) {
		return Mono.just(service.update(bean));
	}

	@DeleteMapping("/{id}")
	public Mono<Boolean> delete(@PathVariable final Integer id) {
		return Mono.just(service.delete(id));
	}

}
