package fr.diginamic.taskboard.business;

import org.springframework.stereotype.Service;

import fr.diginamic.taskboard.persistence.UserRepository;
import fr.diginamic.taskboard.util.generics.GenericService;
import fr.diginamic.taskboard.util.models.User;

@Service
public class UserService extends GenericService<User> {

  protected UserService(final UserRepository repository) {
    super(repository, User.class);
  }
}
