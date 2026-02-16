package co.com.proyecto.starter.tasks.token;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObtenerToken implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
     /*   WebDriverWait wait = new WebDriverWait(driver,20); // Espera hasta 40 segundos

        // Espera hasta que la URL contenga "code="
        wait.until(ExpectedConditions.urlContains("code="));
*/
        String currentUrl = driver.getCurrentUrl();

        Pattern pattern = Pattern.compile("code=([^&]+)");
        Matcher matcher = pattern.matcher(currentUrl);

        if (matcher.find()) {
            String token = matcher.group(1);
            actor.remember("codigoToken", token);
            return token;
        }
        return null;
    }

    public static Question<String> desdeURL() {
        return new ObtenerToken();
    }


}
