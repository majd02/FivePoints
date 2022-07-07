package tn.esprit.stage.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
public class Choix {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "id")
    @SequenceGenerator(name = "id", sequenceName = "ID_SEQ")
    private Long id ;
    @ManyToOne
    private Sujet sujet;
    @ManyToOne
    private UserEntity user;
    private boolean vote;
}
