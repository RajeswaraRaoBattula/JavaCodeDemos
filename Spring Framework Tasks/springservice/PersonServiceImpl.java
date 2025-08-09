package springservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdao.PersonDAO;
import springpojos.Person;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO dao;

    @Override
    public void create(Person person) {
        dao.addPerson(person);
    }

    @Override
    public void update(int id, Person person) {
        dao.updatePerson(id, person);
    }

    @Override
    public void delete(int id) {
        dao.deletePerson(id);
    }

    @Override
    public Person read(int id) {
        return dao.getPersonById(id);
    }

    @Override
    public List<Person> readAll() {
        return dao.getAllPersons();
    }
}
