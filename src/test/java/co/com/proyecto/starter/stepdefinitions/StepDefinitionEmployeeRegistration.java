package co.com.proyecto.starter.stepdefinitions;


import co.com.proyecto.starter.models.Empleado;
import co.com.proyecto.starter.utils.EmpleadoFaker;
import co.com.proyecto.starter.tasks.OpenSite;
import co.com.proyecto.starter.tasks.iniciarsession.IniciarSesionFormulario;
import co.com.proyecto.starter.userinterfaces.search.Home;
import co.com.proyecto.starter.tasks.employee.RegisterEmployee;
import co.com.proyecto.starter.tasks.employee.SearchEmployeeInPim;
import co.com.proyecto.starter.questions.EmpleadoEnResultados;
import net.serenitybdd.screenplay.Actor;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class StepDefinitionEmployeeRegistration {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefinitionEmployeeRegistration.class);

    private final EmpleadoFaker empleadoFaker = new EmpleadoFaker();
    private Empleado empleadoActual;

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

    @When("el usuario registra al empleado con datos generados")
    public void elUsuarioRegistraAlEmpleadoConDatosGenerados() {
        empleadoActual = empleadoFaker.generar();
        LOGGER.info("Empleado generado: {} {} ({})", empleadoActual.getFirstName(), empleadoActual.getLastName(), empleadoActual.getEmployeeUser());

        actor.attemptsTo(
                RegisterEmployee.withLoginDetails(
                        empleadoActual.getFirstName(),
                        empleadoActual.getMiddleName(),
                        empleadoActual.getLastName(),
                        empleadoActual.getEmployeeUser(),
                        empleadoActual.getEmployeePass()
                )
        );
    }

    @And("el usuario abre el modulo PIM y busca el empleado generado")
    public void elUsuarioAbreElModuloPIMYBuscaElEmpleadoGenerado() {
        String busqueda = empleadoActual != null ? empleadoActual.getFullName() : "";
        Target employeeListHeader = Target.the("Employee list header").located(By.xpath("//*[@class='oxd-text oxd-text--h6 --strong']"));

        actor.attemptsTo(
                WaitUntil.the(employeeListHeader, isVisible()).forNoMoreThan(60).seconds(),
                SearchEmployeeInPim.byName(busqueda)
        );
    }

    @Then("el empleado generado debe aparecer en los resultados")
    public void elEmpleadoGeneradoDebeAparecerEnLosResultados() {
        String esperado = empleadoActual != null ? empleadoActual.getFullName() : "";
        String[] partes = esperado.trim().split("\\s+");
        String nombre = partes.length > 0 ? partes[0] : esperado;
        String apellido = partes.length > 1 ? partes[partes.length - 1] : esperado;

        actor.attemptsTo(
                WaitUntil.the(Home.EMPLOYEE_ROW_FIRST, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(Home.EMPLOYEE_ROW_FIRST, containsText(nombre)).forNoMoreThan(30).seconds(),
                WaitUntil.the(Home.EMPLOYEE_LAST_NAME_FIRST, containsText(apellido)).forNoMoreThan(30).seconds()
        );

        Boolean empleadoEncontrado = actor.asksFor(EmpleadoEnResultados.conNombreYApellido(nombre, apellido));
        LOGGER.info("Empleado encontrado en resultados: {}", empleadoEncontrado);

        actor.attemptsTo(
                Ensure.that(empleadoEncontrado).isTrue()
        );
    }


}
