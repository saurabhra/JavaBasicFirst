package TestNgStepByStep.DataProvider;

import org.testng.annotations.DataProvider;

public class MydataProvider {
    @DataProvider(name="NumberInputs")
    public Object[][] getDataFromDataProvider(){

        return new Object[][]
                {
                        {22,33},
                        {12,13}
                };
    }
}
