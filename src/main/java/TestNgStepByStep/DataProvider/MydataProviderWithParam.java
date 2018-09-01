package TestNgStepByStep.DataProvider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class MydataProviderWithParam {
    @DataProvider(name="NumberInputs")
    public Object[][] getDataFromDataProvider(Method m){
if(m.getName().equalsIgnoreCase("sumOfTwoNumbersOne")){
        return new Object[][]
                {
                        {22,33},
                        {12,13}
                };
    } else {
        return new Object[][]
                {
                        {10,20},
                        {40,50}
                };
    }
 }
}
