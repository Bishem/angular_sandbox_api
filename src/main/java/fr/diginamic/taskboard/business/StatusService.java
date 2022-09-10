package fr.diginamic.taskboard.business;

import org.springframework.stereotype.Service;

import fr.diginamic.taskboard.persistence.StatusRepository;
import fr.diginamic.taskboard.util.generics.GenericService;
import fr.diginamic.taskboard.util.models.Status;

@Service
public class StatusService extends GenericService<Status> {

  protected StatusService(final StatusRepository repository) {
    super(repository, Status.class);
  }
}
