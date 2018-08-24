package JavaBasicGeeksforGeeks;
// https://www.geeksforgeeks.org/java-program-for-decimal-to-binary-conversion/

public class DecimalToBinary {

	public static void decimalTobinary(int a) {
		int[] arrint = new int[100];
		int i =0;
		while (a>0) {
			
			arrint[i] = a%2;
			a = a/2;
			i++;
		}
for (int j = i-1; j >= 0; j--) {
	System.out.print(arrint[j]);
}
	}
	
	public static void main(String[] args) {
		int b =17;
		decimalTobinary(b);
	}
}
