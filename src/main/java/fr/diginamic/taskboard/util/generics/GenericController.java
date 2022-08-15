package fr.diginamic.taskboard.util.generics;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import reactor.core.publisher.Mono;

public class GenericController<M> {

	protected GenericService<M> service;

	protected GenericController(final GenericService<M> service) {
		this.service = service;
	}

	@GetMapping("/one")
	public Mono<M> fetch(@RequestBody @Valid final M model) {
		return Mono.just(service.find(model));
	}

	@PostMapping("/match")
	public Mono<Collection<M>> fetchMatching(@RequestBody @Valid final M model) {
		return Mono.just(service.findAll(model));
	}

	@GetMapping
	public Mono<Collection<M>> fetchAll() {
		return Mono.just(service.findAll());
	}

	@PostMapping
	public Mono<M> create(@RequestBody @Valid final M model) {
		return Mono.just(service.create(model));
	}

	@PutMapping
	public Mono<M> update(@RequestBody @Valid final M model) {
		return Mono.just(service.update(model));
	}

	@DeleteMapping("/one")
	public Mono<Boolean> delete(@RequestBody @Valid final M model) {
		return Mono.just(service.delete(model));
	}
}
