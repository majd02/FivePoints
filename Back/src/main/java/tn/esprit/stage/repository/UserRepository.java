package tn.esprit.stage.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.stage.entities.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,String> {
	
	@Query("select (e) from UserEntity e where  e.idUser=:#{#email} and e.mdp=:#{#mdp}")
	UserEntity DoLogin(@Param("email") String email, @Param("mdp") String mdp);
	@Query("select (e) from UserEntity e where e.idUser=:#{#email}")
	UserEntity findByEMail(@Param("email") String email);
	//@Query("select (e) from EspEtudiantEntity e where e.idEt like :year and e.codeDecision='01'")



}
