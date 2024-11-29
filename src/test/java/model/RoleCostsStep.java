package model;
import com.financeModule.CRUD.Services.HorasRegistradasService;
import com.financeModule.CRUD.model.CostoMensualDeActividad;
import com.financeModule.CRUD.Services.CostoMensualService;
import com.financeModule.CRUD.model.Role;
import com.financeModule.CRUD.repository.CostoMensualRepo;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RoleCostsStep {

    private int costoPorHora;
    private int horasRegistradas;
    private int costoTotal;
    private Boolean operationResult;
    private Role rol;

    private CostoMensualService costoMensualService;

    @Mock
    private HorasRegistradasService horasRegistradasService;


    @Before
    public void setUp() {
        operationResult = true;
        costoPorHora = 0;
        horasRegistradas = 0;
        costoTotal = 0;
        rol = null;
        this.horasRegistradasService = new HorasRegistradasService();
        this.costoMensualService = new CostoMensualService();
        this.costoMensualService.setCostoMensualRepo(new CostoMensualRepo() {
            @Override
            public List<CostoMensualDeActividad> findByMes(String mes) {
                return List.of();
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends CostoMensualDeActividad> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends CostoMensualDeActividad> List<S> saveAllAndFlush(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public void deleteAllInBatch(Iterable<CostoMensualDeActividad> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public CostoMensualDeActividad getOne(Long aLong) {
                return null;
            }

            @Override
            public CostoMensualDeActividad getById(Long aLong) {
                return null;
            }

            @Override
            public CostoMensualDeActividad getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends CostoMensualDeActividad> List<S> findAll(Example<S> example) {
                return List.of();
            }

            @Override
            public <S extends CostoMensualDeActividad> List<S> findAll(Example<S> example, Sort sort) {
                return List.of();
            }

            @Override
            public <S extends CostoMensualDeActividad> List<S> saveAll(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public List<CostoMensualDeActividad> findAll() {
                return List.of();
            }

            @Override
            public List<CostoMensualDeActividad> findAllById(Iterable<Long> longs) {
                return List.of();
            }

            @Override
            public <S extends CostoMensualDeActividad> S save(S entity) {
                return null;
            }

            @Override
            public Optional<CostoMensualDeActividad> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(CostoMensualDeActividad entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends CostoMensualDeActividad> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<CostoMensualDeActividad> findAll(Sort sort) {
                return List.of();
            }

            @Override
            public Page<CostoMensualDeActividad> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends CostoMensualDeActividad> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends CostoMensualDeActividad> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends CostoMensualDeActividad> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends CostoMensualDeActividad> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends CostoMensualDeActividad, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        });

    }


    @Given("cargo un costo para una actividad en el año {string}, mes {string}, la experiencia asociada {string}, la actividad asociada {string} y un costo de {int}")
    public void cargoUnCostoParaUnaActividad(String anio, String mes, String experiencia, String actividad, int costo) {
        try{
            this.costoPorHora = costo;

            CostoMensualDeActividad costoActividad = new CostoMensualDeActividad(anio, mes, experiencia, actividad, costo);

            this.rol = new Role("1", actividad, experiencia);


            ResponseEntity<CostoMensualDeActividad> response = costoMensualService.addCost(costoActividad);
        } catch (Exception e) {
            operationResult = false;
        }
    }


    @When("se consulta la cantidad de horas registradas para ese Rol en el año {string} y mes {string} y se obtienen {int} horas")
    public void seConsultaLaCantidadDeHorasRegistradas(String anio, String mes, int horas) {
        if (operationResult){
            this.horasRegistradasService.setHorasRegistradas(horas);

            this.horasRegistradas = horasRegistradasService.obtenerHorasRegistradas(anio, mes, rol);
        }
    }

    @Then("el costo de la actividad debería ser {int}")
    public void elCostoDeLaActividadDeberiaSer(int costoEsperado) {
        this.costoTotal = this.costoPorHora * this.horasRegistradas;

        assertEquals(costoEsperado, this.costoTotal, "El costo total calculado es incorrecto.");

    }

    @Then("la operacion deberia ser cancelada")
    public void operacionCancelada() {
        assertFalse(operationResult);
    }
}
