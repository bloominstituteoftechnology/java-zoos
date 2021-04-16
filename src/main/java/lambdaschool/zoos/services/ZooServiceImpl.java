package lambdaschool.zoos.services;


import lambdaschool.zoos.models.Zoo;
import lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService {

    @Autowired
    ZooRepository zooRepository;

    @Override
    public List<Zoo> findZoos() {
        List<Zoo> list = new ArrayList<>();
        zooRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo findZooById(long id) {
        return zooRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo " + id + " not found!"));
    }
}
