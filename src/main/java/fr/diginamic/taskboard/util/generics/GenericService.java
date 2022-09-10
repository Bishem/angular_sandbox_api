package fr.diginamic.taskboard.util.generics;

import static fr.diginamic.taskboard.util.enums.Errors.ID_IS_NULL;
import static fr.diginamic.taskboard.util.enums.Errors.ID_NOT_NULL;

import java.util.Collection;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.Assert;

import lombok.SneakyThrows;

public class GenericService<M> {

  protected GenericRepository<M> repository;
  protected Class<M> clazz;

  @Autowired
  protected ModelMapper mapper;

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

  public Collection<M> findAll(@Valid final M model) {
    return repository.findAll(Example.of(model));
  }

  public M create(@Valid final M model) {
    Assert.isNull(getId(model), ID_NOT_NULL.message());
    return repository.save(model);
  }

  public M update(@Valid final M model) {
    Assert.notNull(getId(model), ID_IS_NULL.message());
    return repository.save(merge(model, find(model)));
  }

  public Boolean delete(@Valid final M model) {
    repository.delete(find(model));
    return true;
  }

  protected M merge(@Valid final M model, @Valid final M found) {

    mapper.getConfiguration()
      .setMatchingStrategy(MatchingStrategies.STRICT)
      .setCollectionsMergeEnabled(false)
      .setSkipNullEnabled(true);

    mapper.map(model, found);

    return found;
  }

  @SneakyThrows
  protected Integer getId(@Valid final M model) {
    return (Integer) clazz.getDeclaredMethod("getId").invoke(model);
  }
}
