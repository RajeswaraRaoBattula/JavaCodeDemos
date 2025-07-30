package mymockitodemos;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private AccountService accountService;

    @Before
    public void setUp() {
        // Initialized by @RunWith(MockitoJUnitRunner.class)
    }

    // ✅ C-F: Successful Transfer
    @Test
    public void testSuccessfulTransfer() {
        Account from = new Account(1L, 1000);
        Account to = new Account(2L, 500);

        when(accountRepository.findById(1L)).thenReturn(from);
        when(accountRepository.findById(2L)).thenReturn(to);

        accountService.transfer(1L, 2L, 300);

        assertEquals(700, from.getBalance(), 0.01);
        assertEquals(800, to.getBalance(), 0.01);

        verify(accountRepository, times(1)).update(from);
        verify(accountRepository, times(1)).update(to);
        verify(notificationService, times(1)).send(1L, "Transferred 300.0 to account 2");
    }

    // ✅ G: Transfer fails due to insufficient balance
    @Test(expected = IllegalArgumentException.class)
    public void testTransferFailsDueToInsufficientBalance() {
        Account from = new Account(1L, 100);
        Account to = new Account(2L, 500);

        when(accountRepository.findById(1L)).thenReturn(from);
        when(accountRepository.findById(2L)).thenReturn(to);

        accountService.transfer(1L, 2L, 300);

        // Should not reach here if exception thrown
        verify(accountRepository, never()).update(any());
        verify(notificationService, never()).send(anyLong(), anyString());
    }

    //✅ H1: Transfer fails if from account is null
    @Test(expected = IllegalArgumentException.class)
    public void testTransferFailsIfFromAccountIsNull() {
        when(accountRepository.findById(1L)).thenReturn(null);
        when(accountRepository.findById(2L)).thenReturn(new Account(2L, 500));

        accountService.transfer(1L, 2L, 100);

        verify(accountRepository, never()).update(any());
        verify(notificationService, never()).send(anyLong(), anyString());
    }

    // ✅ H2: Transfer fails if to account is null
    @Test(expected = IllegalArgumentException.class)
    public void testTransferFailsIfToAccountIsNull() {
        when(accountRepository.findById(1L)).thenReturn(new Account(1L, 500));
        when(accountRepository.findById(2L)).thenReturn(null);

        accountService.transfer(1L, 2L, 100);

        verify(accountRepository, never()).update(any());
        verify(notificationService, never()).send(anyLong(), anyString());
    }
    
}

