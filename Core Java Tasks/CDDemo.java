/*
 * Create a class called CD whose attributes are Title and singer.  Arrange the CDs in ascending 
order based on the singer name.(Use Comparable)
 */

package myjavacodes;
import java.util.ArrayList;
import java.util.Collections;

class CD implements Comparable<CD> {
    private String title;
    private String singer;

    public CD(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public int compareTo(CD other) {
        return this.singer.compareToIgnoreCase(other.singer);  // ascending by singer name
    }

    public void display() {
        System.out.println("Title: " + title + ", Singer: " + singer);
    }
}


public class CDDemo {
    public static void main(String[] args) {
        ArrayList<CD> cdList = new ArrayList<>();

        // Add sample CD data
        cdList.add(new CD("Shape of You", "Ed Sheeran"));
        cdList.add(new CD("Hello", "Adele"));
        cdList.add(new CD("Thriller", "Michael Jackson"));
        cdList.add(new CD("Levitating", "Dua Lipa"));
        cdList.add(new CD("Blank Space", "Taylor Swift"));

        // Sort CDs by singer name (ascending)
        Collections.sort(cdList);

        // Display sorted CDs
        System.out.println("🎵 Sorted CDs by Singer Name:");
        for (CD cd : cdList) {
            cd.display();
        }
    }
}

