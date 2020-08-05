package local.youngw417.java_zoo.services;

import local.youngw417.java_zoo.models.Telephone;
import local.youngw417.java_zoo.models.Zoo;
import local.youngw417.java_zoo.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TelephoneServiceImpl implements TelephoneService {

    @Autowired
    private TelephoneRepository telephonerepos;

    /**
     * Connects this servive to the User Service
     */
    @Autowired
    private ZooService zooService;

    @Override
    public List<Telephone> findAll() {
        List<Telephone> list = new ArrayList<>();

        telephonerepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Telephone findTelephoneById(long id) {
        return telephonerepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("phone with id " + id + " Not Found!"));
    }

    @Transactional
    @Override
    public void delete(long id) {
        if (telephonerepos.findById(id)
                .isPresent())
        {
            telephonerepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException("Telephone with id " + id + " Not Found!");
        }
    }

    @Transactional
    @Override
    public Telephone update(long phoneid, String phonenumber) {
        if (telephonerepos.findById(phoneid)
                .isPresent())
        {
            Telephone myphone = findTelephoneById(phoneid);
            myphone.setPhonenumber(phonenumber);
            return telephonerepos.save(myphone);
        } else
        {
            throw new EntityNotFoundException("Telephone with id " + phoneid + " Not Found!");
        }
    }

    @Transactional
    @Override
    public Telephone save(long zooid, String phonenumber) {
        Zoo currentZoo = zooService.findZooById(zooid);

        Telephone newPhone = new Telephone(null, phonenumber,
                currentZoo);
        return telephonerepos.save(newPhone);
    }
}
