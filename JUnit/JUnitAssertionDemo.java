 package myjunitdemos;

 import org.junit.Assert;
 import org.junit.Test;
 
 import static org.junit.Assert.*;

 /*
  * JUNIT is an open-source testing framework for java programmers. 
  * The java programmer can create test cases and test his/her own code.

 It is one of the unit testing framework. Current version is junit 4.
  
  To perform unit testing, we need to create test cases. 
  The unit test case is a code which ensures that the program logic works as expected.

 The org.junit package contains many interfaces and classes for junit testing such as Assert, Test, Before, 
 After etc.

 Types of unit testing:::::::::::::::
 There are two ways to perform unit testing: 1) manual testing 2) automated testing.

 1) Manual Testing
 If you execute the test cases manually without any tool support, it is known as 
 manual testing. 
 It is time consuming and less reliable.

 2) Automated Testing
 If you execute the test cases by tool support, it is known as automated testing. 
 It is fast and more reliable.

 The Junit 4.x framework is annotation based!!!!!!!!!!!!

 @Test annotation specifies that method is the test case method.
  */
 /*
  * | ✅ **Reason**                  | 🧠 **Explanation**                                                                   |
 | ----------------------------- | ------------------------------------------------------------------------------------ |
 | ✔️ **Automatic Testing**      | Tests can run automatically every time you build or deploy.                          |
 | ✔️ **Early Bug Detection**    | Catches bugs early, right when you write the code.                                   |
 | ✔️ **Ensures Code Works**     | Confirms your logic behaves correctly under different inputs and edge cases.         |
 | ✔️ **Supports TDD**           | Enables **Test-Driven Development**, where you write tests before writing code.      |
 | ✔️ **Refactoring Confidence** | You can safely change code knowing existing features still work.                     |
 | ✔️ **Integration with Tools** | Works with Maven, Gradle, Eclipse, IntelliJ, Jenkins, etc.                           |
 | ✔️ **Readable Test Reports**  | JUnit gives clear pass/fail results.                                                 |
 | ✔️ **Widely Adopted**         | It’s the **industry standard** in Java testing — strong community and documentation. |

  */


 public class JUnitAssertionDemo {
 	//NO public static void main()!
 	@Test
 	public void mytest1()//test case method
 	{
 		String obj1="junit";//String pool memory
 		String obj2="junit";//String pool memory
 		String obj3=new  String("test");//Heap
 		String obj4="test";//Pool
 		String obj5=null;
 		int var1=1;
 		int var2=2;
 		int[] arithmetic1= {1,2,3,4,5};
 		int[] arithmetic2= {1,2,3,4,5};
 		Assert.assertEquals(obj3,obj4);//The assertEquals() method compares two objects for equality,//using their equals() method. 
 		assertEquals(obj1,obj2);
 		//Check if two object references point to the same object TYPE(stack/heap)
 		//assertSame(obj3,obj4);//failure  bcos one is heap and another one is pool!
 		assertSame(obj1,obj2);
 		//Check if two object references not point to the same object type
 		assertNotSame(obj3,obj4);//different memory returns true
 		//assertNotSame(obj1,obj2);//same memory returns false
 		//Check that an object isn't null
 		assertNotNull(obj1);
 		//Check that an object is null
 		assertNull(obj5);
 		//Check that a condition is true
 		assertTrue(var1 < var2);//1<2
 		//Check that a condition is false
 		assertFalse(var1 > var2);//1>2
 		// Check whether two arrays are 
 		//equal to each other.
 		assertArrayEquals(arithmetic1,arithmetic2);



 	
 	}
 }


