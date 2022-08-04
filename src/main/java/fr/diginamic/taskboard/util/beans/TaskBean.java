package fr.diginamic.taskboard.util.beans;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskBean {

	private Integer id;

	@NonNull
	private String title;
	private String description;

	@NonNull
	private Integer statusId;

	@NonNull
	private String userEmail;
}
