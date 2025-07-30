package myjunitdemos;
import org.junit.Test;
import static org.junit.Assert.*;

class AuthService {
    public static boolean validateLogin(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password cannot be null");
        }
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username or password cannot be empty");
        }

        // Example hardcoded credentials for testing
        return username.equals("admin") && password.equals("admin123");
    }
}


public class ValidTestDemo {

	    @Test
	    public void testValidLogin() {
	        assertTrue(AuthService.validateLogin("admin", "admin123"));
	    }

	    @Test
	    public void testInvalidLogin_WrongUsername() {
	        assertFalse(AuthService.validateLogin("user", "admin123"));
	    }

	    @Test
	    public void testInvalidLogin_WrongPassword() {
	        assertFalse(AuthService.validateLogin("admin", "wrongpass"));
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testLoginWithNullUsername() {
	        AuthService.validateLogin(null, "admin123");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testLoginWithNullPassword() {
	        AuthService.validateLogin("admin", null);
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testLoginWithEmptyUsername() {
	        AuthService.validateLogin("", "admin123");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testLoginWithEmptyPassword() {
	        AuthService.validateLogin("admin", "");
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testLoginWithBothNull() {
	        AuthService.validateLogin(null, null);
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testLoginWithBothEmpty() {
	        AuthService.validateLogin("", "");
	    }
	}



