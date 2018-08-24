package JavaBasicGeeksforGeeks;
// https://www.geeksforgeeks.org/unreachable-statement-using-final-and-non-final-variable-in-java/
class ReachableUsingFinal
{
	final int a = 12, b =16;
	
	void m1()
	{
		while (a<b) {
                 System.out.println("I am  reachable");			
		} 
		        //   System.out.println("I am Not reachable");
	} 
	 
}
public class GfG {
 public static void main(String[] args) {
	ReachableUsingFinal reachable = new ReachableUsingFinal();
	reachable.m1();
}
}
