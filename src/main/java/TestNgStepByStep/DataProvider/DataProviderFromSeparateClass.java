package TestNgStepByStep.DataProvider;

import org.testng.annotations.Test;

public class DataProviderFromSeparateClass {

    @Test(dataProvider="NumberInputs",dataProviderClass = MydataProvider.class)
    public void sumOfTwoNumbers(int num1,int num2) {

        int sum = num1+num2;
        System.out.println("Sum of two numbers is :" +sum);
    }

}
