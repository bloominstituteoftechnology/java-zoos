package local.youngw417.java_zoo.controllers;

import local.youngw417.java_zoo.models.Zoo;
import local.youngw417.java_zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

        /**
         * Using the User service to process user data
         */
        @Autowired
        private ZooService zooService;

        /**
         * Returns a list of all users
         * <br>Example: <a href="http://localhost:2019/users/users">http://localhost:2019/users/users</a>
         *
         * @return JSON list of all users with a status of OK
         * @see UserService#findAll() UserService.findAll()
         */
        @GetMapping(value = "/zoos",
                produces = "application/json")
        public ResponseEntity<?> listAllZoos()
        {
            List<Zoo> myUsers = zooService.findAll();
            return new ResponseEntity<>(myUsers,
                    HttpStatus.OK);
        }

        /**
         * Returns a single user based off a user id number
         * <br>Example: http://localhost:2019/users/user/7
         *
         * @param userId The primary key of the user you seek
         * @return JSON object of the user you seek
         * @see UserService#findUserById(long) UserService.findUserById(long)
         */
        @GetMapping(value = "/zoo/{zooid}",
                produces = "application/json")
        public ResponseEntity<?> getZooById(
            @PathVariable
                    Long zooid)
        {
            Zoo z = zooService.findZooById(zooid);
            return new ResponseEntity<>(z,
                    HttpStatus.OK);
        }

        /**
         * Return a user object based on a given username
         * <br>Example: <a href="http://localhost:2019/users/user/name/cinnamon">http://localhost:2019/users/user/name/cinnamon</a>
         *
         * @param userName the name of user (String) you seek
         * @return JSON object of the user you seek
         * @see UserService#findByName(String) UserService.findByName(String)
         */
        @GetMapping(value = "/zoo/name/{zooName}",
                produces = "application/json")
        public ResponseEntity<?> getZooByName(
            @PathVariable
                    String zooName)
        {
            Zoo z = zooService.findByName(zooName);
            return new ResponseEntity<>(z,
                    HttpStatus.OK);
        }

        /**
         * Returns a list of users whose username contains the given substring
         * <br>Example: <a href="http://localhost:2019/users/user/name/like/da">http://localhost:2019/users/user/name/like/da</a>
         *
         * @param userName Substring of the username for which you seek
         * @return A JSON list of users you seek
         * @see UserService#findByNameContaining(String) UserService.findByNameContaining(String)
         */
        @GetMapping(value = "/user/name/like/{zoorName}",
                produces = "application/json")
        public ResponseEntity<?> getZooLikeName(
            @PathVariable
                    String zooName)
        {
            List<Zoo> z = zooService.findByNameContaining(zooName);
            return new ResponseEntity<>(z,
                    HttpStatus.OK);
        }

        /**
         * Given a complete User Object, create a new User record and accompanying useremail records
         * and user role records.
         * <br> Example: <a href="http://localhost:2019/users/user">http://localhost:2019/users/user</a>
         *
         * @param newuser A complete new user to add including emails and roles.
         *                roles must already exist.
         * @return A location header with the URI to the newly created user and a status of CREATED
         * @throws URISyntaxException Exception if something does not work in creating the location header
         * @see UserService#save(User) UserService.save(User)
         */
        @PostMapping(value = "/zoo",
                consumes = "application/json")
        public ResponseEntity<?> addNewZoo(
            @Validated
            @RequestBody
                    Zoo newzoo) throws
        URISyntaxException
        {
            newzoo.setZooid(0);
            newzoo = zooService.save(newzoo);

            // set the location header for the newly created resource
            HttpHeaders responseHeaders = new HttpHeaders();
            URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{zooid}")
                    .buildAndExpand(newzoo.getZooid())
                    .toUri();
            responseHeaders.setLocation(newUserURI);

            return new ResponseEntity<>(null,
                    responseHeaders,
                    HttpStatus.CREATED);
        }

        /**
         * Given a complete User Object
         * Given the user id, primary key, is in the User table,
         * replace the User record and Useremail records.
         * Roles are handled through different endpoints
         * <br> Example: <a href="http://localhost:2019/users/user/15">http://localhost:2019/users/user/15</a>
         *
         * @param updateUser A complete User including all emails and roles to be used to
         *                   replace the User. Roles must already exist.
         * @param userid     The primary key of the user you wish to replace.
         * @return status of OK
         * @see UserService#save(User) UserService.save(User)
         */
        @PutMapping(value = "/zoo/{zooid}",
                consumes = "application/json")
        public ResponseEntity<?> updateFullZoo(
            @Validated
            @RequestBody
                    Zoo updateZoo,
        @PathVariable
        long zooid)
        {
            updateZoo.setZooid(zooid);
            zooService.save(updateZoo);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        /**
         * Updates the user record associated with the given id with the provided data. Only the provided fields are affected.
         * Roles are handled through different endpoints
         * If an email list is given, it replaces the original emai list.
         * <br> Example: <a href="http://localhost:2019/users/user/7">http://localhost:2019/users/user/7</a>
         *
         * @param updateUser An object containing values for just the fields that are being updated. All other fields are left NULL.
         * @param id         The primary key of the user you wish to update.
         * @return A status of OK
         * @see UserService#update(User, long) UserService.update(User, long)
         */
        @PatchMapping(value = "/zoo/{id}",
                consumes = "application/json")
        public ResponseEntity<?> updateZoo(
            @RequestBody
                    Zoo updateZoo,
        @PathVariable
        long id)
        {
            zooService.update(updateZoo,
                    id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        /**
         * Deletes a given user along with associated emails and roles
         * <br>Example: <a href="http://localhost:2019/users/user/14">http://localhost:2019/users/user/14</a>
         *
         * @param id the primary key of the user you wish to delete
         * @return Status of OK
         */
        @DeleteMapping(value = "/zoo/{id}")
        public ResponseEntity<?> deleteZooById(
        @PathVariable
        long id)
        {
            zooService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
