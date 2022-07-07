package tn.esprit.stage.service.etudiantService;

import tn.esprit.stage.entities.UserEntity;

public interface IUserService {

	UserEntity DoLogin(String email, String mdp);
	public  void register(UserEntity u);


}
