package springdao;

import org.springframework.stereotype.Repository;
import springpojos.Person;

import java.util.*;

@Repository
public class PersonDAOImpl implements PersonDAO {
    private Map<Integer, Person> personMap = new HashMap<>();

    @Override
    public void addPerson(Person person) {
        personMap.put(person.getId(), person);
    }

    @Override
    public void updatePerson(int id, Person updatedPerson) {
        personMap.put(id, updatedPerson);
    }

    @Override
    public void deletePerson(int id) {
        personMap.remove(id);
    }

    @Override
    public Person getPersonById(int id) {
        return personMap.get(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return new ArrayList<>(personMap.values());
    }
}
