package tn.esprit.stage.service.etudiantService;

import tn.esprit.stage.entities.Sujet;

import java.util.List;

public interface IsujetInter {
    public void add(Sujet s);
    public List<Sujet> getAll();
}
