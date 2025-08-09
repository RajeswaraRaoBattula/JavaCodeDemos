package aopfiles;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * JoinPoint:
 * 
 * In Spring AOP, a JoinPoint represents a point during the execution of a
 *  program — like a method call — where an aspect (advice) can be applied.
 * 
 * | Method            | Description                    |
| ----------------- | ------------------------------ |
| `getSignature()`  | Method name, return type, etc. |
| `getArgs()`       | Method arguments               |
| `getTarget()`     | Actual object being called     |
| `getThis()`       | Proxy object                   |
| `toShortString()` | Summary of the join point      |

 */
//CROSS CUTTING CONCERN CLASS
//ASPECT / ADVICE CLASS

public class BankLoggingAspectDemo 
{
	public void wiprologBefore(JoinPoint jp) 
	{
        System.out.println("[LOG] Starting method: " + jp.getSignature().getName());
    }
    public void wiprologAfter(JoinPoint jp) {
        System.out.println("[LOG] Completed method: " + jp.getSignature().getName());
    }
    public void wiprologAfterReturning(JoinPoint jp, Object result) {
        System.out.println("[LOG] Method returned: " + result);
    }

    public void wiprologAfterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("[LOG] Exception in method: " + jp.getSignature().getName());
        System.out.println("[LOG] Error: " + ex.getMessage());
    }
    public Object wiprologExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed(); // run actual method
        long end = System.currentTimeMillis();
        System.out.println("[Around] Method " + pjp.getSignature().getName() + " took " + (end - start) + "ms");
        return result;
}


}
