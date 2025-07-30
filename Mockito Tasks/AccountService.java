package mymockitodemos;

public class AccountService {

    private final AccountRepository accountRepository;
    private final NotificationService notificationService;

    public AccountService(AccountRepository accountRepository, NotificationService notificationService) {
        this.accountRepository = accountRepository;
        this.notificationService = notificationService;
    }

    public void transfer(Long fromId, Long toId, double amount) {
        Account from = accountRepository.findById(fromId);
        Account to = accountRepository.findById(toId);

        if (from == null || to == null) {
            throw new IllegalArgumentException("Account not found");
        }

        from.withdraw(amount);
        to.deposit(amount);

        accountRepository.update(from);
        accountRepository.update(to);

        notificationService.send(fromId, "Transferred " + amount + " to account " + toId);
    }
}
