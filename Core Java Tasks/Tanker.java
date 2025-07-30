/*
 * Create a class called Tank that can be filled and emptied, and has a
termination condition that it must be releaseTank when the object is cleaned up. Write a
finalize( ) that verifies this termination condition. In main( ), test the possible scenarios
that can occur when your Tank is used.
 */
package myjavacodes;

class Tank {
    private boolean isFilled;
    private boolean isReleased;

    // Constructor
    public Tank() {
        isFilled = false;
        isReleased = false;
        System.out.println("Tank created.");
    }

    // Fill the tank
    public void fill() {
        isFilled = true;
        System.out.println("Tank is now filled.");
    }

    // Empty the tank
    public void empty() {
        isFilled = false;
        System.out.println("Tank is now empty.");
    }

    // Release the tank properly
    public void releaseTank() {
        isReleased = true;
        System.out.println("Tank has been released properly.");
    }

    // Finalize method - called by GC if not released
    @Override
    protected void finalize() throws Throwable {
        try {
            if (!isReleased) {
                System.out.println("⚠️ Warning: Tank was not released properly before cleanup!");
            } else {
                System.out.println("Tank finalized after proper release.");
            }
        } finally {
            super.finalize();
        }
    }
}


public class Tanker {
    public static void main(String[] args) {
        // Scenario 1: Proper use - filled and released
        Tank t1 = new Tank();
        t1.fill();
        t1.empty();
        t1.releaseTank();
        t1 = null; // eligible for GC

        // Scenario 2: Improper use - not released
        Tank t2 = new Tank();
        t2.fill();
        // Forgot to call releaseTank()
        t2 = null; // eligible for GC

        // Request garbage collection (not guaranteed)
        System.gc();

        // Give GC time to run
        try {
            Thread.sleep(1000); // delay to allow finalize() if it runs
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main method finished.");
    }
}

