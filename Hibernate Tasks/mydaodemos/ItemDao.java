package mydaodemos;


import mypojos.Item;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ItemDao {
	Configuration cfg=new Configuration().configure("wiprohibernate.cfg.xml");
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addItem(Item item) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(item);
        tx.commit();
        session.close();
    }

    public List<Item> getAllItems() {
        Session session = factory.openSession();
        List<Item> list = session.createQuery("from Item").list();
        session.close();
        return list;
    }

    public Item getItemById(int id) {
        Session session = factory.openSession();
        Item item = (Item) session.get(Item.class, id);
        session.close();
        return item;
    }

    public void updateItem(Item item) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(item);
        tx.commit();
        session.close();
    }

    public void deleteItem(Item item) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(item);
        tx.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}

