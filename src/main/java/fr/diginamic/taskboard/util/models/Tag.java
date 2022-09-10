package fr.diginamic.taskboard.util.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Integer id;

  @Column(unique = true, nullable = false)
  private String name;

  @Valid
  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @ManyToMany(mappedBy = "tags")
  private Collection<Task> tasks;

}
