package mymockitodemos;

public interface AccountRepository {
    Account findById(Long id);
    void update(Account account);
}


