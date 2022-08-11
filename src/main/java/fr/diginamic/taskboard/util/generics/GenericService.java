package fr.diginamic.taskboard.util.generics;

import static fr.diginamic.taskboard.util.enums.Errors.ID_IS_NULL;
import static fr.diginamic.taskboard.util.enums.Errors.ID_NOT_NULL;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.util.Assert;

import lombok.SneakyThrows;

public class GenericService<M> {

	protected final GenericRepository<M> repository;
	protected final Class<M> clazz;

	protected GenericService(
			final GenericRepository<M> repository,
			final Class<M> modelClass) {

		this.repository = repository;
		this.clazz = modelClass;
	}

	public M find(@Valid final M model) {
		return repository.findById(getId(model)).orElseThrow();
	}

	public Collection<M> findAll() {
		return repository.findAll();
	}

	public M create(@Valid final M model) {
		Assert.isNull(getId(model), ID_IS_NULL.message());
		return repository.save(model);
	}

	public M update(@Valid final M model) {
		final var id = getId(model);
		Assert.notNull(id, ID_NOT_NULL.message());
		return repository.save(repository.findById(id).orElseThrow());
	}

	public Boolean delete(@Valid final M model) {
		final var found = repository.findById(getId(model));
		repository.delete(found.orElseThrow());
		return found.isPresent();
	}

	@SneakyThrows
	private Integer getId(@Valid final M model) {
		return (Integer) clazz.getDeclaredMethod("getId").invoke(model);
	}
}
