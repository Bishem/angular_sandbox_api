package fr.diginamic.taskboard.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.taskboard.util.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
