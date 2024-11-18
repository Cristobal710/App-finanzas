package model;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResourceSteps {
    @Given("a employee who's name is {string}, role is {string} and costs {double} per hour")
    public void aEmployeeWhoSNameIsRoleIsAndCostsPerHour(String arg0, String arg1, int arg2, int arg3) {
    }

    @When("I ask for the report of the employee {string}")
    public void iAskForTheReportOfTheEmployee(String arg0) {
    }

    @Then("the report should say the employee {string} costs {double} per hour")
    public void theReportShouldSayTheEmployeeCostsPerHour(String arg0, int arg1, int arg2) {
    }

    @Then("the operation should be denied")
    public void theOperationShouldBeDenied() {
    }
}
