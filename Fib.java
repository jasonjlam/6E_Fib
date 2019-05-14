/** 
  Calculate Fibonacci number n
  3 implementations
  @precondition: n >= 1
  
  Use type "long" instead of "int", because rabbits.
 */

public class Fib {
    /** 
      @return the nth Fibonacci number
              by implementing the recurrence relation
     */
    public static long fib_recurrence( int n) {
        if (n <= 2) {
            return 1;
            }
        else {
            return fib_recurrence(n - 1)
                 + fib_recurrence(n - 2);
        }
    }
     /* These are class / instance methods because...
     It's not acting on a member of class fib, it's calculating something based
     on an arbitrary number given. It'll calculate the same thing regardless
     of the instance it is called from, so it should be a class method.
    */
    // note: begins to slow down around n = ~45 (take more than 5 sec)


    /** 
      @return the nth Fibonacci number
              calculated via the 8th-grade algorithm
     */
    public static long fib_grade8( int n) {
        long first = 1;
        long second = 1;
        for (int i = 1; i < n; i ++) {
            long firstStored = first;
            first = second;
            second += firstStored;          
        }
        return first;
        
    }
    /* Time complexity:
       Consider the size of the problem to be the index n.
       
       As the proxy for the time required, count...
       Count the number of times the variables are changed
       
       Then cost of the the recurrence algorithm
       grows linearly
       as the size of the problem increases,
       because the for loop makes it such that it iterates through n times.
     */


    /** 
      @return the nth Fibonacci number
              calculated via Binet's formula.
              Type is double so that this exercise can
              ignore rounding issues.
     */
    public static double fib_Binet( int n) {
        return (Math.pow((1 + Math.sqrt(5))/ 2.0, n)
             -  Math.pow((1 - Math.sqrt(5))/ 2.0, n))
               / Math.sqrt(5);
    }
    /* Time complexity:
       Consider the size of the problem to be n (the index)
       
       As the proxy for the time required, count the number of operations required
       
       Then cost of the the recurrence algorithm
       grows as a constant (doesn't change)
       as the size of the problem increases,
       because a mathematical formula is being applied which has the same
       number of operations regardless of n.
     */
}
