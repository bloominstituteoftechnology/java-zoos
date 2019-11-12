package local.tylerb.zoo.services;

import local.tylerb.zoo.model.Zoo;
import local.tylerb.zoo.view.Count;

import java.util.List;

public interface Service {

    List<Zoo> getAll();

    Zoo getZooById(long zooid);

    List<Zoo> getZooByLikeName(String name);

    Zoo addZoo(Zoo zoo);

    Zoo updateZoo(long zooid, Zoo zoo);

    void deleteZoo(long id);

    List<Count> animalCount();

    void deleteZooAnimalsItem(long zooid, long animalid);

    void addZooAnimal(long zooid, long animalid);


}
