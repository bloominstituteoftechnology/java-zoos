package services;


import models.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ZooRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
    @Service(value = "zooService")
    public class ZooServiceImpl implements ZooServices{

        @Autowired
        ZooRepository zoorepos;


        @Transactional
        @Override
        public List<Zoo> findAll() {
            List<Zoo> list = new ArrayList<>();
            zoorepos.findAll().iterator().forEachRemaining(list::add);
            return list;
        }


        @Override
        public Zoo findZooById(Long zooId) throws EntityNotFoundException {
            return zoorepos.findById(zooId)
                    .orElseThrow(() -> new EntityNotFoundException("Zoo " + zooId + " doesn't exist!"));
        }
    }


