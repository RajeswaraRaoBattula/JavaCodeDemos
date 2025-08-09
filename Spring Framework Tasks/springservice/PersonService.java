package springservice;

import springpojos.Person;
import java.util.List;

public interface PersonService {
    void create(Person person);
    void update(int id, Person person);
    void delete(int id);
    Person read(int id);
    List<Person> readAll();
}

