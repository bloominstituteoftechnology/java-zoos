package local.youngw417.java_zoo.controllers;

import local.youngw417.java_zoo.models.Telephone;
import local.youngw417.java_zoo.services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/telephons")
public class TelephoneController {
    /**
     * Using the Useremail service to process user, email combinations data
     */
    @Autowired
    TelephoneService telephoneService;

    @GetMapping(value = "/telephones",
            produces = "application/json")
    public ResponseEntity<?> listAllTelephones()
    {
        List<Telephone> allTelephones = telephoneService.findAll();
        return new ResponseEntity<>(allTelephones,
                HttpStatus.OK);
    }


    @GetMapping(value = "/telephone/{phoneid}",
            produces = "application/json")
    public ResponseEntity<?> getTelephoneById(
            @PathVariable
                    Long phoneid)
    {
        Telephone te = telephoneService.findTelephoneById(phoneid);
        return new ResponseEntity<>(te,
                HttpStatus.OK);
    }


    @DeleteMapping(value = "/telephone/{phoneid}")
    public ResponseEntity<?> deleteTelephoneById(
            @PathVariable
                    long phoneid)
    {
        telephoneService.delete(phoneid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/telephone/{phoneid}/phone/{phonenumber}")
    public ResponseEntity<?> updatePhoneNumber(
            @PathVariable
                    long phoneid,
            @PathVariable
                    String phonenumber)
    {
        telephoneService.update(phoneid,
                phonenumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "/zoo/{zooid}/phone/{phonenumber}")
    public ResponseEntity<?> addNewTelephoe(
            @PathVariable
                    long zooid,
            @PathVariable
                    String phonenumber) throws
            URISyntaxException
    {
        Telephone newTelephone = telephoneService.save(zooid,
                phonenumber);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTelephoneURI = ServletUriComponentsBuilder.fromCurrentServletMapping()
                .path("/telephones/telephone/{phoneid}")
                .buildAndExpand(newTelephone.getPhoneid())
                .toUri();
        responseHeaders.setLocation(newTelephoneURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }
}
