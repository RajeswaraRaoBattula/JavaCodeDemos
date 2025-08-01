package mydaodemos;

import mypojos.Account;
import mypojos.Transaction;
import org.hibernate.Session;
import java.util.List;

public class AccountDAO {

    public void saveAccount(Account acc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction txn = session.beginTransaction();

        session.save(acc);
        txn.commit();
        session.close();
    }

    public List<Account> getAllAccounts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Account> accounts = session.createQuery("from Account").list();
        session.close();
        return accounts;
    }
}
