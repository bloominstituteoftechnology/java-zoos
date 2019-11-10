# java-zoos

A student that completes this project shows that they can:
* Use Custom Queries using Spring-Data
* Implement Many-to-Many and One-to-Many relations with auditing fields

## Introduction

This is a basic database scheme with zoos, phone numbers and animals at the zoo.

## Instructions

You are creating a Java Spring REST API server which stores data in an H2 database. The table layouts should be

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

The data.sql file seeds the Zoo Database. 

### You goal is to implement the following endpoints for accessing this API.

* GET /zoos/zoos - returns all zoos with their phone numbers and animals

* PUT /admin/zoos/{id} - update the zoo referenced by the id number with the provided information
  * Update the Zoo and associated phone number. This does NOT address the Zoo Animal combinations! That would be a separate endpoint
  * You could use to test (use id 2):
  
```
{
   "zooname": "SanDiegoZoo",
   "telephones": [
      {
          "phonetype": "education",
          "phonenumber": "555-777-777"
      }
   ]
} 
```

* POST /admin/zoos - add the zoo
  * Add the Zoo and associated phone number(s). This does NOT address the Zoo Animal combinations! That would be a separate end point.
  * In the header return as the location of the newly created zoo POST /admin/zoos/{id}
  * You could use to test:
```
{
   "zooname": "Port Angeles Zoo",
   "telephones": [
      {
          "phonetype": "education",
          "phonenumber": "555-777-777"
      },
      {
          "phonetype": "main",
          "phonenumber": "555-777-777"
      }
   ]
}
```

* DELETE /admin/zoos/{id} - delete the zoo, associated phone numbers, and zoo animals combination associated with this zoo id
  * This should delete the Zoo, associated telephone numbers, and zoo animals combinations associated with this zoo.


* GET /animals/count -  that returns a JSON object list listing the animals and a count of how many zoos where they can be found. Use a custom query for this. 

* GET /zoos/zoos/{id} - returns all information related to a zoo based on its id

* GET /zoos/{name} - returns all information related to a zoo based on its full name


### Stretch Goals

* Expose the endpoint DELETE /admin/zoos/{zooid}/animals/{animalid} - delete the zoo animal combination based off of ids. 
  * Hint: @PathVariable("zooid") long zooid, @PathVariable("animalid") long animalid

* Expose the endpoint POST /admin/zoos/{zooid}/animals/{animalid} - adds the zoo animal combination based off of ids. 
  * Hint: @PathVariable("zooid") long zooid, @PathVariable("animalid") long animalid

