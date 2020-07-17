package com.example.graceezooa.Services;

import com.example.graceezooa.Models.Zoo;
import com.example.graceezooa.Repos.ZooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceIMPL implements ZooService
{

    @Autowired
    private ZooRepo zRepo;

    @Override
    public ArrayList<Zoo> findall()
    {
        ArrayList<Zoo> zooList = new ArrayList<>();
        zRepo.findAll().iterator().forEachRemaining(zooList::add);
        return zooList;
    }

    @Override
    public Zoo findbyid(long id)
    {
        return zRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo "+ id + " not found"));
    }
}
