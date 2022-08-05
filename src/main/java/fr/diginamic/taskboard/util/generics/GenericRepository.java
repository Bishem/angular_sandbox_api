package fr.diginamic.taskboard.util.generics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<M> extends JpaRepository<M, Integer> {

}
