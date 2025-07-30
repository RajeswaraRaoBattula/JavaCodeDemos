package mymockitodemos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalcAppMockitoTester 
{
	
	@InjectMocks
	CalcApp mathApplication=new CalcApp();
	
	@Mock
	CalcServices calcServices;
	
	@Test
	public void testAdd()
	{
		//Stubbing Behaviour
		Mockito.when(calcServices.add(10, 20)).thenReturn(30);
		Mockito.when(calcServices.add(10, 10)).thenReturn(20);
		
		assertEquals(mathApplication.add_1(10, 20),30);
		assertEquals(mathApplication.add_1(10, 10),20);
		
		//assertEquals(mathApplication.add_1(10, 21),31);
	}
}
