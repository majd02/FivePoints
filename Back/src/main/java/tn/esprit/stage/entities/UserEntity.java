package tn.esprit.stage.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "FivePointsUser", schema = "SCOLARITE", catalog = "")
public class UserEntity {
    @Id
    private String idUser;
    private String mdp;
    private String token;
    @Transient
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    @OneToMany(mappedBy = "user")
    private List<Choix> choix ;


}