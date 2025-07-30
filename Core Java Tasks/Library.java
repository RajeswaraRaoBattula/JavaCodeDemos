/*
 * Design a class that acts as a library for the following kinds of media: book, video, and 
newspaper. Provide one version of the class that uses generics and one that does not.
The class should be with add and retrieve methods in order to add and retrieve values 
from the library.
 */

package myjavacodes;
import java.util.ArrayList;

interface Media {
    void displayInfo();
}

class Book implements Media {
    private String title;
    public Book(String title) {
        this.title = title;
    }
    public void displayInfo() {
        System.out.println("Book Title: " + title);
    }
}

class Video implements Media {
    private String name;
    public Video(String name) {
        this.name = name;
    }
    public void displayInfo() {
        System.out.println("Video Name: " + name);
    }
}

class Newspaper implements Media {
    private String date;
    public Newspaper(String date) {
        this.date = date;
    }
    public void displayInfo() {
        System.out.println("Newspaper Date: " + date);
    }
}



class GenericLibrary<T extends Media> {
    private ArrayList<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T retrieve(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }
}


class NonGenericLibrary {
    private ArrayList items = new ArrayList();  // raw type

    public void add(Object item) {
        items.add(item);
    }

    public Object retrieve(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }
}



public class Library {
    public static void main(String[] args) {

        // --- Using Generic Library ---
        System.out.println("🔹 Using Generic Library");
        GenericLibrary<Book> bookLibrary = new GenericLibrary<>();
        bookLibrary.add(new Book("Wipro@02025"));
        Book book = bookLibrary.retrieve(0);
        book.displayInfo();

        GenericLibrary<Video> videoLibrary = new GenericLibrary<>();
        videoLibrary.add(new Video("Java Tutorial"));
        videoLibrary.retrieve(0).displayInfo();

        // --- Using Non-Generic Library ---
        System.out.println("\n🔹 Using Non-Generic Library");
        NonGenericLibrary nonGenericLibrary = new NonGenericLibrary();
        nonGenericLibrary.add(new Book("Clean Code"));
        nonGenericLibrary.add(new Video("Design Patterns"));
        nonGenericLibrary.add(new Newspaper("27-Jul-2025"));

        // Retrieve and cast manually
        Object item1 = nonGenericLibrary.retrieve(0);
        if (item1 instanceof Media) {
            ((Media) item1).displayInfo();
        }

        Object item2 = nonGenericLibrary.retrieve(1);
        if (item2 instanceof Media) {
            ((Media) item2).displayInfo();
        }

        Object item3 = nonGenericLibrary.retrieve(2);
        if (item3 instanceof Media) {
            ((Media) item3).displayInfo();
        }
    }
}

