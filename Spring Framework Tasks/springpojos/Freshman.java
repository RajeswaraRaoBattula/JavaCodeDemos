package springpojos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Freshman {

    private String name;

    @Autowired
    @Qualifier("mainDorm")
    private DormRoom room;

    public Freshman() {
        this.name = "Alex";
    }

    public String getName() {
        return name;
    }

    public DormRoom getRoom() {
        return room;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Room Location: " + room.getLocation());
    }
}
