package springpojos;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "List")
public class BookListWrapper {

    private List<Book> books;

    public BookListWrapper() {}

    public BookListWrapper(List<Book> books) {
        this.books = books;
    }

    @XmlElement(name = "item")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
