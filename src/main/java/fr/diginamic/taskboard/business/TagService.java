package fr.diginamic.taskboard.business;

import org.springframework.stereotype.Service;

import fr.diginamic.taskboard.util.generics.GenericRepository;
import fr.diginamic.taskboard.util.generics.GenericService;
import fr.diginamic.taskboard.util.models.Tag;

@Service
public class TagService extends GenericService<Tag> {

  protected TagService(final GenericRepository<Tag> repository) {
    super(repository, Tag.class);
  }
}
