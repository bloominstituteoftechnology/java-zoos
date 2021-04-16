package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ZooServices {

  List<Zoo> findAll();

  Zoo findZooById(long id);

  //For Post Request
  Zoo save(Zoo zoo);

  //For Put & Patch Request
  Zoo update(Zoo zoo, long id);

  //For Delete Request
  void delete(long id);
}
