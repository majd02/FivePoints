package tn.esprit.stage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stage.entities.Sujet;
import tn.esprit.stage.entities.UserEntity;
@Repository
public interface SujetRepository extends CrudRepository<Sujet,Long> {
}
