package tn.esprit.stage.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String idUser;

    private String mdp;
}
