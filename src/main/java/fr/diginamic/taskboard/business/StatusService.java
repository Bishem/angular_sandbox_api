package fr.diginamic.taskboard.business;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import fr.diginamic.taskboard.persistence.StatusRepository;
import fr.diginamic.taskboard.util.beans.StatusBean;
import fr.diginamic.taskboard.util.models.Status;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;

	public StatusBean find(final Integer id) {
		return beanFrom(statusRepository.findById(id).orElseThrow());
	}

	public List<StatusBean> findAll() {
		return statusRepository.findAll().stream().map(StatusService::beanFrom).toList();
	}

	public StatusBean create(@Valid final StatusBean bean) {
		return beanFrom(statusRepository.save(modelFrom(bean)));
	}

	public StatusBean update(@Valid final StatusBean bean) {
		return beanFrom(statusRepository.save(updateWith(bean)));
	}

	public Boolean delete(final Integer id) {
		statusRepository.delete(statusRepository.findById(id).orElseThrow());
		return true;
	}

	private static StatusBean beanFrom(@Valid final Status status) {
		final var mapper = new ModelMapper();
		return mapper.map(status, StatusBean.class);
	}

	private static Status modelFrom(@Valid final StatusBean bean) {
		Assert.isNull(bean.getId(), "must not have an id");
		final var mapper = new ModelMapper();
		return mapper.map(bean, Status.class);
	}

	private Status updateWith(@Valid final StatusBean bean) {
		Assert.notNull(bean.getId(), "must have an id");
		final var status = statusRepository.findById(bean.getId()).orElseThrow();
		final var mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		mapper.map(bean, status);
		return status;
	}
}
