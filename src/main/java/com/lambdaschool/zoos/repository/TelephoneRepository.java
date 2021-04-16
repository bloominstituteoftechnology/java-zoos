package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepository extends CrudRepository<Telephone, Long> {

  /**
   * JPA Query to find a role by name case insensitive search
   *
   * @param phonenumber the name of the role which you seek
   * @return the first role matching the given name using a case insensitive search
   */
  Telephone findByPhonenumber(String phonenumber);
}
