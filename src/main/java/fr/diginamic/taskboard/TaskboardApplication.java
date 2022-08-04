package fr.diginamic.taskboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.taskboard.persistence.StatusRepository;

@SpringBootApplication
public class TaskboardApplication implements CommandLineRunner {

	@Autowired
	private StatusRepository statusRepository;

	public static void main(final String[] args) {
		SpringApplication.run(TaskboardApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {

	}
}
