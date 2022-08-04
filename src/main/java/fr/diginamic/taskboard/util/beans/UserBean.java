package fr.diginamic.taskboard.util.beans;

import javax.validation.constraints.Email;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {

	@Email
	@NonNull
	private String email;
	private String password;
	private String token;
}
