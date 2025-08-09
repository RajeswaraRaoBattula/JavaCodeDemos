package springdao;

import springpojos.Person;
import java.util.List;

public interface PersonDAO {
    void addPerson(Person person);
    void updatePerson(int id, Person updatedPerson);
    void deletePerson(int id);
    Person getPersonById(int id);
    List<Person> getAllPersons();
}
