/*
 * Write a Java program to read the contents of a text file using BufferedReader and try-with-resources. 
 * The program should handle exceptions gracefully using proper exception handling techniques.
 */
package myjavacodes;

import java.io.*;

public class FileReadDemo {
    public static void main(String[] args) {
        String fileName = "D:\\Wipro_2025\\batchmates.txt"; 
    	

        // Try-with-resources to auto-close BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("Contents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

