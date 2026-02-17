package co.com.proyecto.starter.stepdefinitions;


import co.com.proyecto.starter.tasks.OpenSite;
import co.com.proyecto.starter.tasks.iniciarsession.IniciarSesionFormulario;
import co.com.proyecto.starter.userinterfaces.search.Home;
import co.com.proyecto.starter.userinterfaces.search.LookForInformationEmpleado;
import co.com.proyecto.starter.userinterfaces.search.Pim;
import co.com.proyecto.starter.tasks.employee.RegisterEmployee;
import co.com.proyecto.starter.tasks.employee.SearchEmployeeInPim;
import net.serenitybdd.screenplay.Actor;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class StepDefinitionEmployeeRegistration {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefinitionEmployeeRegistration.class);

    private Actor actor;

    @Before
    public void beforeRun() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el usuario inicia sesion en OrangeHRM con usuario {string} y clave {string}")
    public void elUsuarioIniciaSesionEnOrangeHRMConUsuarioYClave(String usuario, String clave) {
        actor = OnStage.theActorCalled("Usuario");
        actor.wasAbleTo(OpenSite.abrir("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        actor.attemptsTo(IniciarSesionFormulario.about(usuario, clave));
    }

    @When("el usuario registra al empleado {string} {string} {string} con login {string} y clave {string}")
    public void elUsuarioRegistraAlEmpleadoConLoginYClave(String nombre, String segundoNombre, String apellido, String usuarioEmpleado, String claveEmpleado) {
        actor.attemptsTo(
                RegisterEmployee.withLoginDetails(nombre, segundoNombre, apellido, usuarioEmpleado, claveEmpleado)
        );
    }

    @And("el usuario abre el modulo PIM y busca {string}")
    public void elUsuarioAbreElModuloPIMYBusca(String nombreCompleto) {
        actor.attemptsTo(SearchEmployeeInPim.byName(nombreCompleto));
    }

    @Then("el empleado {string} debe aparecer en los resultados")
    public void elEmpleadoDebeAparecerEnLosResultados(String nombreCompleto) {
        String[] partes = nombreCompleto.trim().split("\\s+");
        String nombre = partes.length > 0 ? partes[0] : nombreCompleto;
        String apellido = partes.length > 1 ? partes[partes.length - 1] : nombreCompleto;

        actor.attemptsTo(
                WaitUntil.the(Home.EMPLOYEE_ROW_FIRST, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(Home.EMPLOYEE_ROW_FIRST, containsText(nombre)).forNoMoreThan(30).seconds(),
                WaitUntil.the(Home.EMPLOYEE_LAST_NAME_FIRST, containsText(apellido)).forNoMoreThan(30).seconds()
        );

        String nombreEnFila = Text.of(Home.EMPLOYEE_ROW_FIRST).answeredBy(actor);
        String apellidoEnFila = Text.of(Home.EMPLOYEE_LAST_NAME_FIRST).answeredBy(actor);
        LOGGER.info("PIM row first name text: '{}'", nombreEnFila);
        LOGGER.info("PIM row last name text: '{}'", apellidoEnFila);

    }

 }
