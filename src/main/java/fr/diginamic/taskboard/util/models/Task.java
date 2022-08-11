package fr.diginamic.taskboard.util.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@NotNull
	private String title;
	private String description;

	@Valid
	@NotNull
	@ManyToOne
	private Status status;

	@Valid
	@NotNull
	@ManyToOne
	private User user;
}
