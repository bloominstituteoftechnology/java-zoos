package lambdaschool.zoos.services;

import lambdaschool.zoos.models.Zoo;

import java.util.ArrayList;
import java.util.List;

public interface ZooService {

List<Zoo> findZoos();
Zoo findZooById(long id);
}
