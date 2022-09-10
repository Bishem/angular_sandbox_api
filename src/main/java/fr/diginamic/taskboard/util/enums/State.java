package fr.diginamic.taskboard.util.enums;

import lombok.ToString;

@ToString
public enum State {

  TODO("TODO"),
  DOING("DOING"),
  DONE("DONE"),
  DELETED("DELETED");

  private String value;

  State(final String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
