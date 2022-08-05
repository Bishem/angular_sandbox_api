package fr.diginamic.taskboard.util.generics;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import lombok.SneakyThrows;

public class GenericService<M, B> {

	protected final GenericRepository<M> repository;
	protected final Class<M> modelClass;
	protected final Class<B> beanClass;
	protected final ModelMapper mapper;

	protected GenericService(final GenericRepository<M> repository, final Class<M> modelClass,
			final Class<B> beanClass,
			final ModelMapper mapper) {
		this.repository = repository;
		this.modelClass = modelClass;
		this.beanClass = beanClass;
		this.mapper = mapper;

		mapper.getConfiguration().setSkipNullEnabled(true);
	}

	public B find(final Integer id) {
		return beanFrom(repository.findById(id).orElseThrow());
	}

	public List<B> findAll() {
		return repository.findAll().stream().map(this::beanFrom).toList();
	}

	public B create(@Valid final B bean) {
		Assert.isNull(getId(bean), "must not provide an id to perform said operation");
		return beanFrom(repository.save(modelFrom(bean)));
	}

	public B update(@Valid final B bean) {
		final var id = getId(bean);
		Assert.notNull(id, "must provide an id to perform said operation");
		final var model = repository.findById(id).orElseThrow();
		return beanFrom(repository.save(updateWith(bean, model)));
	}

	public Boolean delete(final Integer id) {
		repository.deleteById(id);
		return true;
	}

	protected B beanFrom(@Valid final M model) {
		return mapper.map(model, beanClass);
	}

	protected M modelFrom(@Valid final B bean) {
		return mapper.map(bean, modelClass);
	}

	protected M updateWith(@Valid final B bean, @Valid final M model) {
		mapper.map(bean, model);
		return model;
	}

	@SneakyThrows
	private Integer getId(@Valid final B bean) {
		final var getIdMethod = beanClass.getDeclaredMethod("getId");
		return (Integer) getIdMethod.invoke(bean);
	}
}
