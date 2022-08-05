package fr.diginamic.taskboard.business;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.diginamic.taskboard.persistence.UserRepository;
import fr.diginamic.taskboard.util.beans.UserBean;
import fr.diginamic.taskboard.util.generics.GenericService;
import fr.diginamic.taskboard.util.models.User;

@Service
public class UserService extends GenericService<User, UserBean> {

//	/**
//	 * this field exists solely to prevent casting in redefined methods
//	 */
//	private final UserRepository userRepository;

	protected UserService(final UserRepository repository, final ModelMapper mapper) {
		super(repository, User.class, UserBean.class, mapper);
//		userRepository = repository;
	}

//	public UserBean findEmail(final String email) {
//		return beanFrom(userRepository.findByEmail(email).orElseThrow());
//	}
//
//	@Override
//	public UserBean create(@Valid final UserBean bean) {
//		Assert.notNull(bean.getPassword(), "user must provide password upon creation");
//		return beanFrom(userRepository.save(modelFrom(bean)));
//	}
//
//	@Override
//	public UserBean update(@Valid final UserBean bean) {
//		final var user = userRepository.findByEmail(bean.getEmail()).orElseThrow();
//		return beanFrom(userRepository.save(updateWith(bean, user)));
//	}
//
//	public Boolean deleteEmail(final String email) {
//		repository.delete(userRepository.findByEmail(email).orElseThrow());
//		return true;
//	}
}
