package fr.diginamic.taskboard.util.generics;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import reactor.core.publisher.Mono;

public class GenericController<M, B> {

	protected final GenericService<M, B> service;

	protected GenericController(final GenericService<M, B> service) {
		this.service = service;
	}

	@GetMapping
	public Mono<List<B>> fetchAll() {
		return Mono.just(service.findAll());
	}

	@GetMapping("/{id}")
	public Mono<B> fetch(@PathVariable final Integer id) {
		return Mono.just(service.find(id));
	}

	@PostMapping
	public Mono<B> create(@RequestBody @Valid final B bean) {
		return Mono.just(service.create(bean));
	}

	@PutMapping
	public Mono<B> update(@RequestBody @Valid final B bean) {
		return Mono.just(service.update(bean));
	}

	@DeleteMapping("/{id}")
	public Mono<Boolean> delete(@PathVariable final Integer id) {
		return Mono.just(service.delete(id));
	}
}
