package fr.diginamic.taskboard.business;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import fr.diginamic.taskboard.persistence.UserRepository;
import fr.diginamic.taskboard.util.beans.UserBean;
import fr.diginamic.taskboard.util.models.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserBean find(final String email) {
		return beanFrom(repository.findByEmail(email).orElseThrow());
	}

	public List<UserBean> findAll() {
		return repository.findAll().stream().map(UserService::beanFrom).toList();
	}

	public UserBean create(@Valid final UserBean bean) {
		return beanFrom(repository.save(modelFrom(bean)));
	}

	public UserBean update(@Valid final UserBean bean) {
		return beanFrom(repository.save(updateWith(bean)));
	}

	public Boolean delete(final String email) {
		repository.delete(repository.findByEmail(email).orElseThrow());
		return true;
	}

	private static UserBean beanFrom(@Valid final User user) {
		final var mapper = new ModelMapper();
		return mapper.map(user, UserBean.class);
	}

	private static User modelFrom(@Valid final UserBean bean) {
		Assert.notNull(bean.getPassword(), "user must provide password upon creation");
		final var mapper = new ModelMapper();
		return mapper.map(bean, User.class);
	}

	private User updateWith(@Valid final UserBean bean) {
		final var user = repository.findByEmail(bean.getEmail()).orElseThrow();
		final var mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		mapper.map(bean, user);
		return user;
	}
}
