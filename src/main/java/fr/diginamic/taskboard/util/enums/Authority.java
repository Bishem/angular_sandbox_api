package fr.diginamic.taskboard.util.enums;

import lombok.ToString;

@ToString
public enum Authority {

	ADMIN("ADMIN"),
	USER("USER");

	private String level;

	Authority(final String level) {
		this.level = level;
	}

	public String level() {
		return level;
	}
}
