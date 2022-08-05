package fr.diginamic.taskboard.persistence;

import org.springframework.stereotype.Repository;

import fr.diginamic.taskboard.util.generics.GenericRepository;
import fr.diginamic.taskboard.util.models.Status;

@Repository
public interface StatusRepository extends GenericRepository<Status> {

}
