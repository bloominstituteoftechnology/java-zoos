# java-zoos

A student that completes this project shows that they can:
* Use Custom Queries usng Spring-Data
* Connect to PostgreSQL Using Spring-Data
* Implement Many-to-many and One-to-many relations

## Introduction

This is a basic database scheme with zoos, phone number and animals at the zoo.

## Instructions

Create a REST API server to store and read data from a PostgreSQL database. A suggestion - work in H2 first, get everything working and then covert to PostgreSQL. The table layouts should be

* Zoo
  * zooid - long primary key
  * zooname - String

* Telephone
  * phoneid - long primary key
  * phonetype - String
  * phonenumber - String
  * zooid - foreign key
  
There is a one to many relationship between zoos and telephones. One zoo can have multiple phone numbers but each phone number can only belong to one zoo.

Use the file data.sql to seed your database.

* Animal
  * animalid - long primary key
  * animaltype - String

There is a many to many relationship between zoos and animals. A zoo may have many animal types and an animal type may be at many zoos.

Expose the following end points

* GET /zoos/zoos - returns all zoos with their phone numbers and animals
* GET /zoos/{name} - return the zoo with this name with its phone numbers and animals
  * Hint: Remember in the web world, a space is a %20 so to search for Point Defiance Zoo, replace the spaces with %20:
  * localhost:2019/zoos/Point%20Defiance%20Zoo

* GET /animals/animals - returns all animals with their zoos
* GET /animals/{name} - return the animal with a list of zoos where they can be found

* GET /animals/count -  that returns a JSON object list listing the animals and a count of how many zoos where they can be found. Use a custom query for this.

For the PUT and POST you can assume you are sent all the data with the appropriate ids included

* PUT /admin/zoos/{id} - update the zoo referenced by the id number with the provided information
  * Update the Zoo and associated phone number. This does NOT address the Zoo Animal combinations! That would be a separate end point

* POST /admin/zoos - add the zoo
  * Add the Zoo and associated phone number(s). This does NOT address the Zoo Animal combinations! That would be a separate end point.

* DELETE /admin/zoos/{id} - delete the zoo, associated phone numbers, and zoo animals combination associated with this zoo id
  * This should delete the Zoo, associated telephone numbers, and zoo animals combinations associated with this zoo.
  

### Stretch Goals

* Expose the end point DELETE /admin/zoos/{zooid}/animals/{animalid} - delete the zoo animal combination based off of ids. 
  * Hint: @PathVariable("zooid", long zooid), @PathVariable("animalid") long animalid
* Expose the end point POST /admin/zoos/{zooid}/animals/{animalid} - adds the zoo animal combination based off of ids. 
  * Hint: @PathVariable("zooid", long zooid), @PathVariable("animalid") long animalid
* Log to the console each time a record in the database is changed.
