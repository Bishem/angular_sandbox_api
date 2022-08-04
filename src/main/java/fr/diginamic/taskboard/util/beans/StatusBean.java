package fr.diginamic.taskboard.util.beans;

import org.springframework.lang.NonNull;

import fr.diginamic.taskboard.util.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusBean {

	private Integer id;

	@NonNull
	private State state;
}
