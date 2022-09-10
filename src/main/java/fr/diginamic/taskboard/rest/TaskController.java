package fr.diginamic.taskboard.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.taskboard.business.TaskService;
import fr.diginamic.taskboard.util.generics.GenericController;
import fr.diginamic.taskboard.util.models.Task;

@RestController
@RequestMapping("/api/task")
@CrossOrigin("http://localhost:4200")
public class TaskController extends GenericController<Task> {

  protected TaskController(final TaskService service) {
    super(service);
  }
}
