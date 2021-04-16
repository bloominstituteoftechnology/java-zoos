package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.*;
import com.lambdaschool.zoos.repository.ZooRepository;
import org.hibernate.hql.internal.ast.tree.AbstractNullnessCheckNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;
import javax.persistence.EntityNotFoundException;
import java.util.*;

@Transactional
@Service
public class ZooServicesImpl implements ZooServices{

  @Autowired
  private ZooRepository zoorepos;

  @Autowired
  private AnimalServices animalServices;

  @Override
  public List<Zoo> findAll() {
    List<Zoo> list = new ArrayList<>();
    zoorepos.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  @Override
  public Zoo findZooById(long id) throws EntityNotFoundException {
    return zoorepos.findById(id).orElseThrow(()->
        new EntityNotFoundException("Zoo id: " + id + " not found!"));
  }

  @Override
  public Zoo save(Zoo zoo) {
    Zoo newZoo = new Zoo();

    if (zoo.getZooid() != 0) {
      zoorepos.findById(zoo.getZooid()).orElseThrow(()->
          new EntityNotFoundException("Zoo id: " + zoo.getZooid() + " not found!"));
      newZoo.setZooid(zoo.getZooid());
    }
    newZoo.setZooname(zoo.getZooname().toLowerCase());

    newZoo.getAnimals().clear();
    for (ZooAnimals z : zoo.getAnimals()) {
      Animal newAnimal = animalServices.findAnimalById(z.getAnimal().getAnimalid());
      newZoo.getAnimals().add(new ZooAnimals(newZoo, newAnimal, z.getIncomingzoo()));
    }

    newZoo.getTelephones().clear();
    for (Telephone t : zoo.getTelephones()) {
      newZoo.getTelephones().add(new Telephone(t.getPhonetype(), t.getPhonenumber(),newZoo));
    }
    return zoorepos.save(newZoo);
  }

  @Transactional
  @Override
  public Zoo update(Zoo zoo, long id) {
    Zoo currentZoo = findZooById(id);
    if (zoo.getZooname() !=null) {
      currentZoo.setZooname(zoo.getZooname());
    }

    if (zoo.getAnimals().size() > 0){
      currentZoo.getAnimals().clear();
      for (ZooAnimals z : zoo.getAnimals()){
        Animal newAnimal = animalServices.findAnimalById(z.getAnimal().getAnimalid());
        currentZoo.getAnimals().add(new ZooAnimals(currentZoo, newAnimal, z.getIncomingzoo()));
      }
    }

    if (zoo.getTelephones().size() > 0) {
      currentZoo.getTelephones().clear();
      for (Telephone t : zoo.getTelephones()) {
        currentZoo.getTelephones().add(new Telephone(t.getPhonenumber(), t.getPhonetype(), currentZoo));
      }
    }
    return zoorepos.save(currentZoo);
  }

  @Transactional
  @Override
  public void delete(long id) {
  zoorepos.findById(id).orElseThrow(()->
      new EntityNotFoundException("Zoo id: " + id + " not found!"));
  zoorepos.deleteById(id);
  }
}
