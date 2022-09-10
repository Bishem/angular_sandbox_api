package fr.diginamic.taskboard.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.taskboard.util.generics.GenericController;
import fr.diginamic.taskboard.util.generics.GenericService;
import fr.diginamic.taskboard.util.models.Tag;

@RestController
@RequestMapping("/api/tag")
@CrossOrigin("http://localhost:4200")
public class TagController extends GenericController<Tag> {

  protected TagController(final GenericService<Tag> service) {
    super(service);
  }

}
