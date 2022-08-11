package fr.diginamic.taskboard.util.enums;

public enum Errors {

	ID_IS_NULL("must provide an id to perform said operation"),
	ID_NOT_NULL("must not provide an id to perform said operation");

	public final String message;

	Errors(final String message) {
		this.message = message;
	}

	public String message() {
		return message;
	}
}
