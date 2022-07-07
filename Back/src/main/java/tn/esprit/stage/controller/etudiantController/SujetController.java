package tn.esprit.stage.controller.etudiantController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stage.entities.LoginRequest;
import tn.esprit.stage.entities.Sujet;
import tn.esprit.stage.entities.UserEntity;
import tn.esprit.stage.service.etudiantService.IUserService;
import tn.esprit.stage.service.etudiantService.IsujetInter;

import java.util.List;

@CrossOrigin(origins = {"http://depot.esprit-tn.com/","http://localhost:4200/"})
//@CrossOrigin(origins = {"http://localhost:4200/"})
@RequestMapping(value = "/Sujet")
@RestController
public class SujetController {
    @Autowired
    IsujetInter sujetSer;
    @RequestMapping(value = "/addsujet", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody

    public void addsujet(@RequestBody Sujet s)
    {
        sujetSer.add(s);
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody

    public List<Sujet> getall(@RequestBody Sujet s)
    {
       return sujetSer.getAll();
    }
}
