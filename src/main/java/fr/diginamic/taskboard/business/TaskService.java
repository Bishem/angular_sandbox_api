package fr.diginamic.taskboard.business;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.taskboard.persistence.StatusRepository;
import fr.diginamic.taskboard.persistence.TaskRepository;
import fr.diginamic.taskboard.persistence.UserRepository;
import fr.diginamic.taskboard.util.beans.TaskBean;
import fr.diginamic.taskboard.util.generics.GenericService;
import fr.diginamic.taskboard.util.models.Task;

@Service
public class TaskService extends GenericService<Task, TaskBean> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StatusRepository statusRepository;

	protected TaskService(final TaskRepository repository, final ModelMapper mapper) {
		super(repository, Task.class, TaskBean.class, mapper);
	}

	@Override
	protected Task updateWith(@Valid final TaskBean bean, @Valid final Task model) {

		mapper.addMappings(new PropertyMap<TaskBean, Task>() {

			@Override
			protected void configure() {
				map().setStatus(statusRepository.findById(source.getStatusId()).orElseThrow());
				map().setUser(userRepository.findByEmail(source.getUserEmail()).orElseThrow());
			}
		});

		return super.updateWith(bean, model);
	}
}
