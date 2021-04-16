package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Telephone;
import com.lambdaschool.zoos.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class TelephoneServicesImpl implements TelephoneServices {

  @Autowired
  private TelephoneRepository telephoneRepository;

  @Override
  public List<Telephone> findAllTelephones() {
    List<Telephone> list = new ArrayList<>();
    telephoneRepository.findAll().iterator().forEachRemaining(list::add);
    return list;
  }
}
