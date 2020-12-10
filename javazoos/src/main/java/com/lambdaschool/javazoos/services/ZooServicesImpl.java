package com.lambdaschool.javazoos.services;


import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooServices")
public class ZooServicesImpl implements ZooServices
{
    @Autowired
    private ZooRepository zoorepos;


    @Override
    public List<Zoo> findAllZoos()
    {
        List<Zoo> rtnList = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }
}
