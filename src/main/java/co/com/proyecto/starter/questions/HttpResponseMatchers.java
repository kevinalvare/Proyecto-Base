package co.com.proyecto.starter.questions;

import net.serenitybdd.screenplay.Question;


public class HttpResponseMatchers {



    public static Question<Boolean> isStatus(int expectedStatus) {
        return HttpResponseCode.status().map(status -> status == expectedStatus);
    }

}
