package joyce.guava.main;

import com.google.common.base.Preconditions;

/**前置条件Preconditions提供静态方法来检查方法或构造函数
 * @author hyb
 */
public class PreconditionDemo {


       public static void main(String[] args) {
           try {
               getValue(4);
           } catch (IndexOutOfBoundsException e){
               System.out.println(e.getMessage());
           }
 
           try {
               sum(4,null);
           } catch (NullPointerException e){
               System.out.println(e.getMessage());
           }
 
           try {
               sqrt(-11);
           } catch (IllegalArgumentException e){
               System.out.println(e.getMessage());
           }
 
       }
 
       private static double sqrt(double input){
           Preconditions.checkArgument(input>0.0,
                   "Illegal Argument passed: Negative value %s.",input);
           return Math.sqrt(input);
       }
 
       private static int sum(Integer a,Integer b){
           a=Preconditions.checkNotNull(a,
                   "Illegal Argument passed: First parameter is Null.");
           b=Preconditions.checkNotNull(b,
                   "Illegal Argument passed: Second parameter is Null.");
           return a+b;
       }
 
       private static int getValue(int input){
           int[] data={1,2,3,4,5};
           int index=Preconditions.checkElementIndex(input,data.length,
                   "Illegal Argument passed: Invalid index.");
           return data[index];
       }
 
}