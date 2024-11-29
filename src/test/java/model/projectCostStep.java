package model;

import com.financeModule.CRUD.Services.CostoMensualService;
import com.financeModule.CRUD.Services.HorasRegistradasService;
import com.financeModule.CRUD.model.CostoMensualDeActividad;
import com.financeModule.CRUD.model.Project;
import com.financeModule.CRUD.model.Role;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class projectCostStep {

        private Project proyecto;
        private int costoTotal;
        private int horasRegistradas;
        private int costoPorHora;

        @Mock
        private HorasRegistradasService horasRegistradasService;

        @Given("cargo un costo para una actividad en el año {string}, mes {string}, la experiencia asociada {string}, la actividad asociada {string} con un costo de {int}")
        public void cargoUnCostoParaUnaActividad(String anio, String mes, String experiencia, String actividad, int costo) {
            this.costoPorHora = costo;
        }

        @And("un proyecto {string} con {int} horas asociadas a la actividad")
        public void crearProyecto(String proyecto, int horasRegistradas) {
            this.proyecto = new Project();
            this.proyecto.setNombre(proyecto);
            horasRegistradasService = new HorasRegistradasService();
            horasRegistradasService.setHorasRegistradas(horasRegistradas);
        }

        @When("consulto el costo de {string} para el año {string}, mes {string}")
        public void consultarHoras(String nombreProyecto, String anio, String mes){
            if (this.proyecto.getNombre().equals(nombreProyecto)){
                this.horasRegistradas = horasRegistradasService.obtenerHorasRegistradas(anio, mes, nombreProyecto);
            }
        }

        @Then("el costo total del proyecto debería ser {int}")
        public void verificarCostoTotalDelProyecto(int costoEsperado) {
            costoTotal = horasRegistradas * costoPorHora;
            assertEquals(costoEsperado, costoTotal, "El costo total calculado es incorrecto.");
        }
    }
