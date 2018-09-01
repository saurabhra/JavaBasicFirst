package JavaEasyGeeksForGeeks;
// https://www.geeksforgeeks.org/generating-random-numbers-in-java/
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratingRandaomNumber {
public static void main(String[] args) {
	int rand_int1 = ThreadLocalRandom.current().nextInt();
	
	System.out.println("Print random number :"+rand_int1);
	
	Random random = new Random();
	int numb = random.nextInt(10);
	
	System.out.println(numb);
}
}
