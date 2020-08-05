package local.youngw417.java_zoo.controllers;

import local.youngw417.java_zoo.models.Animal;
import local.youngw417.java_zoo.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class AnimalController {
    /**
     * Using the Role service to process Role data
     */
    @Autowired
    AnimalService animalService;

    /**
     * List of all roles
     * <br>Example: <a href="http://localhost:2019/roles/roles">http://localhost:2019/roles/roles</a>
     *
     * @return JSON List of all the roles and their associated users
     * @see RoleService#findAll() RoleService.findAll()
     */
    @GetMapping(value = "/animals",
            produces = "application/json")
    public ResponseEntity<?> listAnimals()
    {
        List<Animal> allAnimals = animalService.findAll();
        return new ResponseEntity<>(allAnimals,
                HttpStatus.OK);
    }

    /**
     * The Role referenced by the given primary key
     * <br>Example: <a href="http://localhost:2019/roles/role/3">http://localhost:2019/roles/role/3</a>
     *
     * @param roleId The primary key (long) of the role you seek
     * @return JSON object of the role you seek
     * @see RoleService#findRoleById(long) RoleService.findRoleById(long)
     */
    @GetMapping(value = "/animal/{animalid}",
            produces = "application/json")
    public ResponseEntity<?> getAnimalById(
            @PathVariable
                    Long animalid)
    {
        Animal a = animalService.findAnimalById(animalid);
        return new ResponseEntity<>(r,
                HttpStatus.OK);
    }

    /**
     * The Role with the given name
     * <br>Example: <a href="http://localhost:2019/roles/role/name/data">http://localhost:2019/roles/role/name/data</a>
     *
     * @param roleName The name of the role you seek
     * @return JSON object of the role you seek
     * @see RoleService#findByName(String) RoleService.findByName(String)
     */
    @GetMapping(value = "/animal/name/{animalName}",
            produces = "application/json")
    public ResponseEntity<?> getAnimalByName(
            @PathVariable
                    String animalName)
    {
        Animal a = animalService.findByName(animalName);
        return new ResponseEntity<>(a,
                HttpStatus.OK);
    }

    /**
     * Given a complete Role object, create a new Role record
     * <br>Example: <a href="http://localhost:2019/roles/role">http://localhost:2019/roles/role</a>
     *
     * @param newRole A complete new Role object
     * @return A location header with the URI to the newly created role and a status of CREATED
     * @see RoleService#save(Role) RoleService.save(Role)
     */
    @PostMapping(value = "/animal",
            consumes = "application/json")
    public ResponseEntity<?> addNewAnimal(
            @Validated
            @RequestBody
                    Animal newAnimal)
    {
        // ids are not recognized by the Post method
        newAnimal.setAnimalid(0);
        newAnimal = animalService.save(newAnimal);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newAnimalURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{animalid}")
                .buildAndExpand(newAnimal.getAnimalid())
                .toUri();
        responseHeaders.setLocation(newAnimalURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }
}
