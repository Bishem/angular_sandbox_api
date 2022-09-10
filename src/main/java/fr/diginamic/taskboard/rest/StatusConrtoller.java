package fr.diginamic.taskboard.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.taskboard.business.StatusService;
import fr.diginamic.taskboard.util.generics.GenericController;
import fr.diginamic.taskboard.util.models.Status;

@RestController
@RequestMapping("/api/status")
@CrossOrigin("http://localhost:4200")
public class StatusConrtoller extends GenericController<Status> {

  protected StatusConrtoller(final StatusService service) {
    super(service);
  }
}
