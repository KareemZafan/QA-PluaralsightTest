package steps_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Atm {

    double currentAmount = 0 ;
    double amountBeforeWithdrawal = 0 ;


    @Given("I have ${int} in my account")
    public void i_have_$_in_my_account(Integer int1) {
        currentAmount = int1;
        amountBeforeWithdrawal = currentAmount;
    }
    @When("I request ${int}")
    public void i_request_$(Integer int1) {
        currentAmount -= int1;
    }
    @Then("${int} should be dispensed")
    public void $_should_be_dispensed(Integer int1) {
        Assert.assertEquals((amountBeforeWithdrawal - currentAmount) , (double) int1);
    }


}
