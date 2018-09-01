package TestNgStepByStep.DataProvider;

import org.testng.annotations.Test;

public class DataProviderFromSeparateClassWithParam {

    @Test(dataProvider="NumberInputs",dataProviderClass = MydataProviderWithParam.class)
    public void sumOfTwoNumbersOne(int num1,int num2) {

        int sum = num1+num2;
        System.out.println("Sum of two numbers is :" +sum);
    }
    @Test(dataProvider="NumberInputs",dataProviderClass = MydataProviderWithParam.class)
    public void sumOfTwoNumbersTow(int num1,int num2) {

        int sum = num1+num2;
        System.out.println("Sum of two numbers is :" +sum);
    }

}
