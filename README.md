# java-zoos

# Introduction

This is a basic database scheme with zoos, phone number and animals at the zoo.

#Instructions

Create a REST API server to store and read data from a MySQL data. The table layouts should be

* Zoo
  * zooid - long primary key
  * zooname - String

* Telephone
  * phoneid - long primary key
  * phonetype - String
  * phonenumber - String
  * zooid - foreign key
  
There is a one to many relationship between zoos and telephones. One zoo can have multiple phone numbers but each phone number can only belong to one zoo.

* Animal
  * animalid - long primary key
  * animaltype - String

There is a many to many relationship between zoos and animals. A zoo may have many animal types and an animal type may be at many zoos.

* End points should return the data worked with or nothing if no data was found.
* Swagger should be used to document your API, The default documentation is sufficient assuming appropriate names are used in your coding.

Expose the following end points

* GET /zoos/zoos - returns all zoos with their phone numbers and animals
* GET /zoos/{name} - return the zoo with this name with its phone numbers and animals

* GET /animals/animals - returns all animals with their zoos
* GET /animals/{name} - return the animal with a list of zoos where they can be found

For the PUT and POST you can assume you are sent all the data with the appropriate ids included

* PUT /admin/zoos/{id} - update the zoo referenced by the id number with the provided information
* PUT /admin/phones/{id} - update the telephone referenced by the id number with the provided information
* PUT /admin/animals/{id} - update the animal referenced by the id number with the provided information

* POST /admin/zoos - add the zoo
* POST /admin/phones - add the phone number
* POST /admin/animals - add the animal
* POST /admin/zoos/animals - add the zooid, animalid combination to the zoo animals relations table

* DELETE /admin/zoos/{id} - delete the zoo, associated phone numbers, and zoo animals combination associated with this zoo id
* DELETE /admin/phones/{id} - delete the phone number associated with this id
* DELETE /admin/animals/{id} - delete the animal associated with this id including all the appropriate zoo animal combinations
* DELETE /admin/zoos/{zooid}/animals/{animalid} - delete the zoo animal combination based off of ids. 
  * Hint: @PathVariable("zooid", long zooid), @PathVariable("animalid") long animalid

Expose at least the following actuator endpoints to help with system management
* /health
* /info
* /metrics

Stretch Goals
* Update each of the three actuator endpoints to report your own messages
* Expose the end point /animals/count that returns a JSON object list listing the animals and a count of how many zoos where they can be found.
* Log to the console each time a record in the database is changed.
