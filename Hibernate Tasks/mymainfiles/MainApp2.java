package mymainfiles;

import mypojos.Author;
import mypojos.Book;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class MainApp2 {
    static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Book\n2. Add Author\n3. View Books\n4. View Authors\n5. Delete Book\n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            case 1:
                addBook(sc);
                break;
            case 2:
                addAuthor(sc);
                break;
            case 3:
                viewBooks();
                break;
            case 4:
                viewAuthors();
                break;
            case 5:
                deleteBook(sc);
                break;
            case 6:
                factory.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }

            }
  }

    private static void addBook(Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        Book book = new Book(title);

        System.out.print("How many authors? ");
        int count = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter author name: ");
            String authorName = sc.nextLine();

            Query<Author> q = session.createQuery("from Author where name = :name", Author.class);
            q.setParameter("name", authorName);
            Author author = q.uniqueResult();

            if (author == null) {
                author = new Author(authorName);
                session.persist(author);
            }

            book.getAuthors().add(author);
        }

        session.persist(book);
        tx.commit();
        session.close();
        System.out.println("Book added successfully!");
    }

    private static void addAuthor(Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter author name: ");
        String name = sc.nextLine();

        Author author = new Author(name);
        session.persist(author);

        tx.commit();
        session.close();
        System.out.println("Author added successfully!");
    }

    private static void viewBooks() {
        Session session = factory.openSession();
        List<Book> books = session.createQuery("from Book", Book.class).list();

        for (Book book : books) {
            System.out.println("Book: " + book.getTitle());
            book.getAuthors().forEach(author -> System.out.println(" -> Author: " + author.getName()));
        }

        session.close();
    }

    private static void viewAuthors() {
        Session session = factory.openSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();

        for (Author author : authors) {
            System.out.println("Author: " + author.getName());
            author.getBooks().forEach(book -> System.out.println(" -> Book: " + book.getTitle()));
        }

        session.close();
    }

    private static void deleteBook(Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter book ID to delete: ");
        int id = sc.nextInt();

        Book book = session.get(Book.class, id);
        if (book != null) {
            session.remove(book);
            System.out.println("Book deleted.");
        } else {
            System.out.println("Book not found.");
        }

        tx.commit();
        session.close();
    }
}
