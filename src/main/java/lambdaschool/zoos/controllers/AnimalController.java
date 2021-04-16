package lambdaschool.zoos.controllers;

import lambdaschool.zoos.services.AnimalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController {

   @Autowired
   private AnimalServices animalServices;


    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> getAnimalCount(){
        return new ResponseEntity<>(animalServices.getAnimalCount(), HttpStatus.OK);
    }

}
