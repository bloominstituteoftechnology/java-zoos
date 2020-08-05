package local.youngw417.java_zoo.services;

import local.youngw417.java_zoo.models.Zoo;

import java.util.List;

public interface ZooService {

    List<Zoo> findAll();
    Zoo findZooById(long zooid);
    Zoo findByName(String name);
    List<Zoo> findByNameContaining(String name);
    Zoo save(Zoo zoo);
    Zoo update(Zoo zoo, long id);
    void delete(long id);
}
