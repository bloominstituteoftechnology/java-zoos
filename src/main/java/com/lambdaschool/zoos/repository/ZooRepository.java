package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.models.Zoo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository <Zoo, Long> {

  Zoo findByZooid(long id);

  @Modifying
  @Query(value = "UPDATE zoos SET zooname = :zooname, lastmodifiedby = :uname, " +
      "lastmodifieddate = CURRENT_TIMESTAMP  WHERE zooid = :id", nativeQuery = true)
  void updateZooName(  String uname, Long id,String zooname);
}
