package fr.diginamic.taskboard.business;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.diginamic.taskboard.persistence.TaskRepository;
import fr.diginamic.taskboard.util.generics.GenericService;
import fr.diginamic.taskboard.util.models.Task;

@Service
public class TaskService extends GenericService<Task> {

	protected TaskService(
			final TaskRepository repository,
			final ModelMapper mapper) {

		super(repository, Task.class, mapper);
	}
}
