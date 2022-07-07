package tn.esprit.stage.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Table(name = "sujet")
public class Sujet {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id")
    @SequenceGenerator(name = "id", sequenceName = "ID_SEQ")
    private Long id ;
    private String titre ;
    private  String description ;
    @JsonIgnore
    @OneToMany(mappedBy = "sujet")
   private List<Choix> choix ;
}
