package fr.diginamic.taskboard.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import fr.diginamic.taskboard.util.generics.GenericRepository;
import fr.diginamic.taskboard.util.models.User;

@Repository
public interface UserRepository extends GenericRepository<User> {

	Optional<User> findByEmail(String email);
}
