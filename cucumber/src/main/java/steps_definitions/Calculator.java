package steps_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Calculator {
    int a , b , c ;
    int result = 0 ;

    @Given("i have  {int} , {int} and  {int}")
    public void i_have_and(Integer n1, Integer n2, Integer n3) {
       a = n1;
       b = n2;
       c = n3;

    }

    @When("adding {int}, {int} ,{int}")
    public void adding(Integer int1, Integer int2, Integer int3) {
        result = a + b + c ;
    }
    @Then("result should be {int}")
    public void result_should_be(Integer resultFromFeature) {
        Assert.assertEquals(result,resultFromFeature);
    }


    @When("subtracting {int}, {int}, {int}")
    public void subtracting(Integer int1, Integer int2, Integer int3) {
        result = int1 - int2 - int3 ;
    }


}
