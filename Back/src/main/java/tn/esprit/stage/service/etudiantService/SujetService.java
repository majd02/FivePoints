package tn.esprit.stage.service.etudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stage.entities.Sujet;
import tn.esprit.stage.repository.SujetRepository;

import java.util.List;

@Service
public class SujetService implements IsujetInter{
    @Autowired
    SujetRepository SR ;
    @Override
    public void add(Sujet s) {
        SR.save(s);
    }

    @Override
    public List<Sujet> getAll() {
      return (List<Sujet>) SR.findAll();
    }

}
