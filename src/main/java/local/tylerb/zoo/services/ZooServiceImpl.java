package local.tylerb.zoo.services;

import local.tylerb.zoo.model.Zoo;
import local.tylerb.zoo.repo.ZooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService {

    @Autowired
    ZooRepo zooRepo;

    @Override
    public List<Zoo> getAll() {
        List<Zoo> list = new ArrayList<>();
        zooRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
