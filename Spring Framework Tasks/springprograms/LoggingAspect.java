package springprograms;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    public void logBeforeMethod() {
        System.out.println("[LOG] Before method execution...");
    }

    public void logAfterReturning() {
        System.out.println("[LOG] After method successfully returned...");
    }

    public void logAfterThrowing() {
        System.out.println("[LOG] Exception occurred during method execution...");
    }

    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Proceed with method
        long end = System.currentTimeMillis();
        System.out.println("[LOG] Execution time: " + (end - start) + " ms");
        return result;
    }
}
