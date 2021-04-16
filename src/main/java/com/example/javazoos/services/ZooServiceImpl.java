package com.example.javazoos.services;

import com.example.javazoos.models.Zoo;
import com.example.javazoos.repository.ZoosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooServices")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    private ZoosRepository zoosRepository;

    @Override
    public List<Zoo> findAll()
    {
        List<Zoo> rtnList = new ArrayList<>();
        zoosRepository.findAll()
                      .iterator()
                      .forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Zoo findByZooId(long zooid)
    {
        return zoosRepository.findById(zooid).orElseThrow(()-> new EntityNotFoundException("Zoo id " + zooid + " Not Found"));
    }
}
