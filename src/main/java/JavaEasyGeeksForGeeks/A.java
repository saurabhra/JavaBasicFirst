package JavaEasyGeeksForGeeks;

// https://www.geeksforgeeks.org/using-throw-catch-and-instanceof-to-handle-exceptions-in-java/
import java.util.Random;

public class A {
void func(int n)
{
	try {
		int x = 10/n;
		int y[] = new int[n];
		
		y[x] = 10;
		
		System.out.println("Exception doesn't occurred");
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Exception occurred");
	}
}

public static void main(String[] args) {
	new A().func(new Random().nextInt(10));
}
}
