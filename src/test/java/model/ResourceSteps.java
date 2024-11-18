package model;

import com.financeModule.CRUD.Services.ResourceService;
import com.financeModule.CRUD.model.Resource;
import com.financeModule.CRUD.model.Role;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ResourceSteps {

    private Resource resource;
    private Role role;
    private boolean operationResult;


    @Given("a employee who's name is {string}, role is {string}, has dni {int} and his activity is {string}")
    public void CreateEmployee(String name, String role, int dni, String activity) {
        try{
            this.resource = new Resource(name, role, activity, dni);
            operationResult = true;
        } catch (IllegalArgumentException e){
            operationResult = false;
        }

    }

    @When("I ask for the report of the employee {string}")
    public void iAskForTheReportOfTheEmployee(String employee) {
        this.role = resource.getRole();
    }

    @Then("the report should say the employee {string} role is {string} and his activity is {string}")
    public void theReportShouldSayTheEmployeeRoleIsAndHisActivityIs(String name, String role, String activity) {
        assertEquals(resource.getNombre(), name);
        assertEquals(this.role.getNombre(), activity);
        assertEquals(this.role.getExperiencia(), role);
    }

    @Then("the operation should be denied")
    public void theOperationShouldBeDenied() {
        assertFalse(operationResult);
    }

}
