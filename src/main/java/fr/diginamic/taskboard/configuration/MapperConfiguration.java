package fr.diginamic.taskboard.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

	@Bean
	ModelMapper mapper() {

		final var mapper = new ModelMapper();

		mapper.getConfiguration().setSkipNullEnabled(true);

		return mapper;
	}

}
