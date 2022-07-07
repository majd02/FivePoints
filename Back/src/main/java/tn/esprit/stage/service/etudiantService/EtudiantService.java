package tn.esprit.stage.service.etudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stage.entities.UserEntity;
import tn.esprit.stage.repository.UserRepository;

import java.util.Date;


@Service
public class EtudiantService implements IUserService {

	@Autowired
	UserRepository userRepository;


	@Override
	public UserEntity DoLogin(String email, String mdp) {

		UserEntity e = new UserEntity();
		Date d = new Date();

		//String year = d.toString().substring(d.toString().length() - 2);







		if (userRepository.DoLogin(email, mdp) != null) {



			e = userRepository.DoLogin(email, mdp);



			}else {
			if (userRepository.findByEMail(email) != null) {
				e = userRepository.findByEMail(email);
				e.setToken("PASSWD");
			} else {
				e.setToken("UNKNOWN");

			}

		}
			return e;
		}

	@Override
	public void register(UserEntity u) {
		userRepository.save(u);
	}


}