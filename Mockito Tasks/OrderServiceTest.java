/*
 * Scenario: In an OrderService, there’s a method placeOrder() that internally calls PaymentService.processPayment().

Mock PaymentService

Verify that processPayment() is called exactly once
 */

package mymockitodemos;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderServiceTest {

    @Mock
    private PaymentService paymentService;

    private OrderService orderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(paymentService);
    }

    @Test
    public void testPlaceOrder_CallsProcessPaymentOnce() {
        // Act
        orderService.placeOrder();

        // Assert
        verify(paymentService, times(1)).processPayment();
    }
}
