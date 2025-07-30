package myjavacodes;

public class RethrowingExceptionEx{

    // Method that throws an exception
    public static void someMethod2() throws Exception {
        throw new Exception("Exception thrown in someMethod2");
    }

    // Method that catches and rethrows the exception
    public static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("Exception caught in someMethod, rethrowing...");
            throw e;  // rethrowing the exception
        }
    }

    // Main method
    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println("Exception caught in main:");
            e.printStackTrace(); // Print the stack trace of the rethrown exception
        }
    }
}
