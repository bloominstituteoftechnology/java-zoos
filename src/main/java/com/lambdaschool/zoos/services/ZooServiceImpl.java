package com.lambdaschool.zoos.services;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService{
}
