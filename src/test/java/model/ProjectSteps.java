package model;

import com.financeModule.CRUD.model.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectSteps {
    private Project project;
    private Boolean operationResult;
    private int hoursRemaining;


    @Given("I accept a project thats gonna take {int} hours to complete, worth {double} and from the client {string}")
    public void iAcceptAProjectThatsGonnaTakeHoursToCompleteWorthAndFromTheClient(int hoursToComplete, double payment, String client) {
        try {
            this.project = new Project(client, hoursToComplete, payment);
            operationResult = true;
        } catch (Exception e) {
            operationResult = false;
        }
    }

    @Then("the project should be {int} hours remaining to complete")
    public void theProjectShouldBeHoursRemainingToComplete(int hoursToComplete) {
        assertTrue(operationResult);
        assertEquals(hoursToComplete, project.getHoursToComplete());
    }

    @When("I ask for the hours left on the project after {int} hours of work")
    public void iAskForTheHoursLeftOnTheProject(int hoursWorked) {
        try{
            this.hoursRemaining = (project.getHoursToComplete() - hoursWorked);
            if (this.hoursRemaining < 0){
                this.hoursRemaining = 0;
                project.setProjectFinished(true);
            }
        } catch (Exception e) {
            operationResult = false;
        }
    }

    @Then("the hours remaining are {int}")
    public void theHoursReaminingAre(int hoursRemaining) {
        assertTrue(operationResult);
        assertEquals(hoursRemaining, this.hoursRemaining);
    }

    @Given("I have no projects currently")
    public void iHaveNoProjectsCurrently() {
        project = null;
    }
}
