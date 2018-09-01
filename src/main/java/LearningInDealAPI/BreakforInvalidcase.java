package LearningInDealAPI;


public class BreakforInvalidcase {
    public static void main(String args[]) {
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9, 10};
        int temp, tempNext;
        for (int i = 0; i < intArray.length; i++) {
            temp = intArray[i];
            tempNext = intArray[i+1];

            if (temp == tempNext) {
                System.out.println("printing value : " + i);
                break;
            }
            else {
                System.out.println("value is nott printed");
            }
            {


            }
        }
    }}
