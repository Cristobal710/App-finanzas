package model;

import com.financeModule.CRUD.model.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectSteps {
    private Project project;
    private Boolean operationResult;
    private int hoursRemaining;
    private double amountCharged;
    private double costOfMonth;
    private double roi;

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

    @When("I charge the client {int} hours into the project for the work done")
    public void iChargeTheClientWhenHoursIntoTheProjectForTheWorkDone(int hoursWorked) {
        try{
            this.amountCharged = project.calculateBillForHoursWorked(hoursWorked);
            this.hoursRemaining = (project.getHoursToComplete() - hoursWorked);
        } catch (IllegalCallerException e){
            operationResult = false;
        }

    }

    @Then("the bill should be of {double} and the hours remaining should be {int}")
    public void theBillShouldBeOfAndTheHoursRemainingShouldBe(double bill, int hoursRemaining) {
        assertEquals(bill, this.amountCharged);
        assertEquals(hoursRemaining, this.hoursRemaining);
    }

    @And("its a project of deed")
    public void projectOfDeed() {
        project.setProjectOfDeed(true);
    }

    @When("I ask for the monthly report after the first month has finished and {int} people are working on the project")
    public void iAskForTheMonthlyReportAfterTheFirstMonthHasFinished(int amountOfPeopleWorkingOnProject) {
        try{
            this.costOfMonth = project.calculateCostOfProjectForMonths(1, amountOfPeopleWorkingOnProject);
        } catch (Exception e) {
            operationResult = false;
        }

    }


    @Then("the report should say the project's monthly cost is of {double}")
    public void theReportShouldSayTheProjectSMonthlyCostIsOf(double amount) {
        assertEquals(amount, this.costOfMonth);
    }

    @And("the final gaining of the project is {double}")
    public void theFinalGainingOfTheProjectIs(double gainings) {
        project.setProjectGainings(gainings);
    }

    @When("I ask for the ROI of said project")
    public void iAskForTheROIOfSaidProject() {
        try {
            this.roi = project.calculateROI();
        } catch (Exception e) {
            operationResult = false;
        }

    }

    @Then("the ROI of the project is {double}")
    public void theROIOfTheProjectIs(double finalAmount) {
        assertEquals(finalAmount, this.roi);
    }

    @Given("a project that gave {double} on gainings and costs {double}")
    public void aProjectThatGaveOnGainingsAndCosts(int arg0, int arg1, int arg2, int arg3) {
    }

    @Given("a project that hasn't finished")
    public void aProjectThatHasnTFinished() {
    }
}
