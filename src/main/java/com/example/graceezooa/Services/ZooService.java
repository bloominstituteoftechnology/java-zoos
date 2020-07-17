package com.example.graceezooa.Services;

import com.example.graceezooa.Models.Zoo;

import java.util.ArrayList;
import java.util.List;

public interface ZooService
{
    //returns all zoos with their phone numbers and animals
    ArrayList<Zoo> findall();

    //returns all information related to a zoo based on its id
    Zoo findbyid(long id);
}
