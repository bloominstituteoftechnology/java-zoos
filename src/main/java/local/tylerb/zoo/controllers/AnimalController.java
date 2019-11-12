package local.tylerb.zoo.controllers;

import local.tylerb.zoo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    Service service;

    @GetMapping(value = "/count")
    public ResponseEntity<?> getCount() {
        return new ResponseEntity<>(service.animalCount(), HttpStatus.OK);
    }
}
