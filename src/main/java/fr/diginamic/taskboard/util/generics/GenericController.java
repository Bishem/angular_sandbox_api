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

	protected final GenericService<M> service;

	protected GenericController(final GenericService<M> service) {
		this.service = service;
	}

	@GetMapping("/all")
	public Mono<Collection<M>> fetchAll() {
		return Mono.just(service.findAll());
	}

	@GetMapping("/one")
	public Mono<M> fetch(@RequestBody @Valid final M model) {
		return Mono.just(service.find(model));
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
