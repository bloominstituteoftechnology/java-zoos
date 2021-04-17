package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService{

    @Autowired
    private ZooRepository zooRepos;


    @Override
    public List<Zoo> findAllZoos() {
        List<Zoo> list = new ArrayList<>();
       zooRepos.findAll()
               .iterator()
               .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo findZooById(long id) throws EntityNotFoundException {
        return zooRepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Zoo"+ id + "not found"));

    }


}
