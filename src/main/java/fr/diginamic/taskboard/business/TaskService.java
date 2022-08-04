package fr.diginamic.taskboard.business;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import fr.diginamic.taskboard.persistence.StatusRepository;
import fr.diginamic.taskboard.persistence.TaskRepository;
import fr.diginamic.taskboard.persistence.UserRepository;
import fr.diginamic.taskboard.util.beans.TaskBean;
import fr.diginamic.taskboard.util.models.Task;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private UserRepository userRepository;

	public TaskBean find(final Integer id) {
		return beanFrom(taskRepository.findById(id).orElseThrow());
	}

	public List<TaskBean> findAll() {
		return taskRepository.findAll().stream().map(TaskService::beanFrom).toList();
	}

	public TaskBean create(@Valid final TaskBean bean) {
		return beanFrom(taskRepository.save(modelFrom(bean)));
	}

	public TaskBean update(@Valid final TaskBean bean) {
		return beanFrom(taskRepository.save(updateWith(bean)));
	}

	public Boolean delete(final Integer id) {
		taskRepository.delete(taskRepository.findById(id).orElseThrow());
		return true;
	}

	private static TaskBean beanFrom(@Valid final Task task) {
		final var mapper = new ModelMapper();
		return mapper.map(task, TaskBean.class);
	}

	private static Task modelFrom(@Valid final TaskBean bean) {
		Assert.isNull(bean.getId(), "must not have an id");
		final var mapper = new ModelMapper();
		return mapper.map(bean, Task.class);
	}

	private Task updateWith(@Valid final TaskBean bean) {

		Assert.notNull(bean.getId(), "must have an id");
		
		final var mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		mapper.addMappings(new PropertyMap<TaskBean, Task>() {

			@Override
			protected void configure() {
				map().setStatus(statusRepository.findById(source.getStatusId()).orElseThrow());
				map().setUser(userRepository.findByEmail(source.getUserEmail()).orElseThrow());
			}
		});

		final var task = taskRepository.findById(bean.getId()).orElseThrow();
		mapper.map(bean, task);
		return task;
	}
}
