package myjunitdemos;

import org.junit.Test;
import static org.junit.Assert.*;

class StringUtils {
    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }
}


public class StringReverseTestDemo {

	    @Test
	    public void testReverseRegularString() {
	        assertEquals("cba", StringUtils.reverse("abc"));
	        assertEquals("987654321", StringUtils.reverse("123456789"));
	        assertEquals("!dlroW ,olleH", StringUtils.reverse("Hello, World!"));
	    }

	    @Test
	    public void testReverseEmptyString() {
	        assertEquals("", StringUtils.reverse(""));
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testReverseNullInput() {
	        StringUtils.reverse(null);
	    }
	}

