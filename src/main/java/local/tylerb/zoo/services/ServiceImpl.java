package local.tylerb.zoo.services;

import local.tylerb.zoo.model.Telephone;
import local.tylerb.zoo.model.Zoo;
import local.tylerb.zoo.repo.AnimalRepo;
import local.tylerb.zoo.repo.ZooRepo;
import local.tylerb.zoo.view.Count;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service(value = "service")
public class ServiceImpl implements Service {

    @Autowired
    ZooRepo zooRepo;

    @Autowired
    AnimalRepo animalRepo;

    @Override
    public List<Zoo> getAll() {
        List<Zoo> list = new ArrayList<>();
        zooRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo getZooById(long zooid) {
        return zooRepo.findById(zooid).orElseThrow(() -> new EntityNotFoundException("id: " + zooid + " not found!"));
    }

    @Override
    public List<Zoo> getZooByLikeName(String name) {
        return zooRepo.findByZoonameContainingIgnoreCase(name);
    }

    @Override
    public Zoo addZoo(Zoo zoo) {
        Zoo newZoo = new Zoo();
        newZoo.setZooname(zoo.getZooname());

        for (Telephone t : zoo.getTelephones()) {
            Telephone phone = new Telephone(t.getPhonetype(), t.getPhonenumber(), newZoo);
            newZoo.getTelephones().add(phone);
        }

        return zooRepo.save(newZoo);
    }

    @Override
    public Zoo updateZoo(long zooid, Zoo zoo) {
        Zoo getZoo = zooRepo.findById(zooid).orElseThrow(() -> new EntityNotFoundException(Long.toString(zooid)));

        if (zoo.getZooname() != null){
            getZoo.setZooname(zoo.getZooname());
        }

        if (zoo.getTelephones().size() > 0) {
            for (Telephone t : zoo.getTelephones()) {
                Telephone phone = new Telephone(t.getPhonetype(), t.getPhonenumber(), getZoo);
                getZoo.getTelephones().add(phone);
            }
        }

        return zooRepo.save(getZoo);
    }

    @Override
    public void deleteZoo(long id) {
        zooRepo.deleteById(id);
    }

    @Override
    public List<Count> animalCount() {
        return animalRepo.countLocations();
    }

    @Override
    public void deleteZooAnimalsItem(long zooid, long animalid) {
        zooRepo.findById(zooid)
                .orElseThrow(() -> new EntityNotFoundException("User id " + zooid + " not found!"));
        animalRepo.findById(animalid)
                .orElseThrow(() -> new EntityNotFoundException("Role id " + animalid + " not found!"));

        animalRepo.deleteItemFromZooAnimals(zooid, animalid);
    }

    @Override
    public void addZooAnimal(long zooid, long animalid) {
        zooRepo.findById(zooid)
                .orElseThrow(() -> new EntityNotFoundException("User id " + zooid + " not found!"));
        animalRepo.findById(animalid)
                .orElseThrow(() -> new EntityNotFoundException("Role id " + animalid + " not found!"));

        animalRepo.insertZooAnimals(zooid, animalid);
    }
}
