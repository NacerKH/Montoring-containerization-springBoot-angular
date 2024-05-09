package tn.esprit.devops_project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.devops_project.entities.Operator;

public interface OperatorRepository extends CrudRepository<Operator, Long> {

}
