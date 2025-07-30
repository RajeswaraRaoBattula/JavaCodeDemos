package myjavacodes;

public class ExceptionOrder {
    public static void main(String[] args) {

        // 1. NegativeArraySizeException
        try {
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            System.out.println("\nCaught NegativeArraySizeException:");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nCaught ArrayIndexOutOfBoundsException:");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("\nCaught General Exception:");
            e.printStackTrace();
        }

        // 2. ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[3];
            int value = arr[5];
        } catch (NegativeArraySizeException e) {
            System.out.println("\nCaught NegativeArraySizeException:");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nCaught ArrayIndexOutOfBoundsException:");
            e.printStackTrace();
        }

        // 3. StringIndexOutOfBoundsException
        try {
            String str = "Java";
            char ch = str.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\nCaught StringIndexOutOfBoundsException:");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nCaught IndexOutOfBoundsException:");
            e.printStackTrace();
        }

        // 4. IndexOutOfBoundsException (List)
        try {
            java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
            list.add(10);
            int x = list.get(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nCaught IndexOutOfBoundsException:");
            e.printStackTrace();
        }

        // 5. NullPointerException
        try {
            String str = null;
            int len = str.length();
        } catch (NullPointerException e) {
            System.out.println("\nCaught NullPointerException:");
            e.printStackTrace();
        }

        // 6. ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("\nCaught ArithmeticException:");
            e.printStackTrace();
        }
    }
}
