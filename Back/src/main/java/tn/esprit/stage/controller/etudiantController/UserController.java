package tn.esprit.stage.controller.etudiantController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stage.entities.LoginRequest;
import tn.esprit.stage.entities.UserEntity;
import tn.esprit.stage.service.etudiantService.IUserService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://depot.esprit-tn.com/","http://localhost:4200/"})
//@CrossOrigin(origins = {"http://localhost:4200/"})
@RequestMapping(value = "/User")
@RestController
public class UserController {

	@Autowired
	IUserService userService;



	@RequestMapping(value = "/doLogin", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody

	public UserEntity DoLogin(@RequestBody LoginRequest er) {

		UserEntity e = userService.DoLogin(er.getIdUser(), er.getMdp());
		if (e != null && e.getToken()==null) {
			String token = getJWTToken(er.getIdUser());
			e.setToken(token);
		}

		return e;
	}


	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 900000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}


}
