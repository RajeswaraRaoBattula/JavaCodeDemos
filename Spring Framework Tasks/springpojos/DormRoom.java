package springpojos;

import org.springframework.stereotype.Component;

@Component("mainDorm") // name matches the @Qualifier
public class DormRoom {
    private String roomNumber = "A101";

    public String getRoomNumber() {
        return roomNumber;
    }

	public String getLocation() {
		// TODO Auto-generated method stub
		return null;
	}
}
