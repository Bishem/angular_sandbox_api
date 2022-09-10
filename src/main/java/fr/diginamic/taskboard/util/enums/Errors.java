package fr.diginamic.taskboard.util.enums;

import lombok.ToString;

@ToString
public enum Errors {

  ID_IS_NULL("must not provide an id to perform said operation"),
  ID_NOT_NULL("must provide an id to perform said operation");

  private final String message;

  Errors(final String message) {
    this.message = message;
  }

  public String message() {
    return message;
  }
}
