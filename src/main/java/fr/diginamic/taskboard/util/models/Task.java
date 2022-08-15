package fr.diginamic.taskboard.util.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

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

	@Column(nullable = false)
	private String title;
	private String description;

	@Valid
	@ManyToOne(optional = false)
	private Status status;

	@Valid
	@ManyToOne(optional = false)
	private User user;
}
