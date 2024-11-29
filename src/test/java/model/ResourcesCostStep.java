package model;
import com.financeModule.CRUD.model.Resource;
import com.financeModule.CRUD.Services.HorasRegistradasService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mock;

public class ResourcesCostStep {
    private Resource recurso;
    private int costoTotal;
    private int horasAsignadas;
    private int costoPorHora;

    @Mock
    private HorasRegistradasService horasRegistradasService;

    @Given("asigno un costo para una actividad en el año {string}, mes {string}, la experiencia asociada {string}, la actividad asociada {string} con un costo de {int}")
    public void asignoUnCostoParaUnaActividad(String anio, String mes, String experiencia, String actividad, int costo) {
        // Aquí asignamos el costo a la actividad. El costo puede ser usado posteriormente.
        this.costoPorHora = costo;
    }

    @And("un recurso llamado {string} con {int} horas asignadas a la actividad")
    public void crearRecurso(String nombreRecurso, int horas) {
        // Creamos un nuevo recurso y asignamos las horas correspondientes.
        this.recurso = new Resource();
        this.recurso.setNombre(nombreRecurso);
        this.horasAsignadas = horas;
        horasRegistradasService = new HorasRegistradasService();
        horasRegistradasService.setHorasRegistradas(horas);
    }

    @When("consulto el costo del recurso llamado {string} para el año {string}, mes {string}")
    public void consultarCostoDelRecurso(String nombreRecurso, String anio, String mes) {
        // Verificamos que el recurso sea el correcto
        if (this.recurso.getNombre().equals(nombreRecurso)) {
            // Calculamos las horas registradas
            this.horasAsignadas = horasRegistradasService.obtenerHorasRegistradas(anio, mes, nombreRecurso);
        }
    }

    @Then("el costo total del recurso debería ser {int}")
    public void verificarCostoTotalDelRecurso(int costoEsperado) {
        // Calculamos el costo total basado en las horas asignadas y el costo por hora
        costoTotal = horasAsignadas * costoPorHora;
        assertEquals(costoEsperado, costoTotal, "El costo total calculado es incorrecto.");
    }
}
