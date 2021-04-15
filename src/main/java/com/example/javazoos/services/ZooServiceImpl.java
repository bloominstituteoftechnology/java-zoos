package com.example.javazoos.services;

import com.example.javazoos.models.Zoo;
import com.example.javazoos.repository.ZoosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "zooServices")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    private ZoosRepository zoosRepository;

    @Override
    public List<Zoo> findAllZoos()
    {
        return null;
    }

    @Override
    public Zoo findByZooId(long zooid)
    {
        return null;
    }
}
