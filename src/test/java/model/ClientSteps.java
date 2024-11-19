package model;

import com.financeModule.CRUD.model.Client;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientSteps {
    private Client client;
    private Boolean operationResult;
    private int amountOfProjects;
    private int projectsDelayed;

    @Given("a client with name {string} and {int} projects currently being done for him")
    public void aClientWithNameAndProjectsCurrentlyBeingDoneForHim(String name, int projects) {
        this.client = new Client(name, projects);
    }

    @When("I ask for the projects that the client {string} has")
    public void iAskForTheProjectsThatTheClientHas(String clientName) {
        if (clientName.equals(client.getNombreCliente())){
            this.amountOfProjects = client.getProjects();
            this.projectsDelayed = client.getProjectsDelayed();
            return;
        }
        operationResult = false;
    }

    @Then("there should be {int} projects at his name")
    public void thereShouldBeProjectsAtHisName(int amountOfProjects) {
        assertEquals(amountOfProjects, client.getProjects());
    }

    @Then("there should be {int} projects at his name and {int} should be delayed")
    public void thereShouldBeProjectsAtHisNameAndShouldBeDelayed(int totalProjects, int delayedProjects) {
        assertEquals(totalProjects, this.amountOfProjects);
        assertEquals(delayedProjects, this.projectsDelayed);
    }

    @And("one of them is delayed")
    public void oneOfThemIsDelayed() {
        client.setProjectsDelayed(1);
    }
}
