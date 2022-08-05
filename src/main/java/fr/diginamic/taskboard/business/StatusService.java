package fr.diginamic.taskboard.business;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.diginamic.taskboard.persistence.StatusRepository;
import fr.diginamic.taskboard.util.beans.StatusBean;
import fr.diginamic.taskboard.util.generics.GenericService;
import fr.diginamic.taskboard.util.models.Status;

@Service
public class StatusService extends GenericService<Status, StatusBean> {

	protected StatusService(final StatusRepository repository, final ModelMapper mapper) {
		super(repository, Status.class, StatusBean.class, mapper);
	}
}
