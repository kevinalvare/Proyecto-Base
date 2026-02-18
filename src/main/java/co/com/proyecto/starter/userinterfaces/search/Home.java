package co.com.proyecto.starter.userinterfaces.search;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Home {
    public static Target PIM = Target.the("Opción PIM").located(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
    public static Target ADD = Target.the("Opción PIM").located(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"));
    public static Target PRIMER_NOMBRE = Target.the("Opción PIM").located(By.xpath("//*[@class=\"oxd-input oxd-input--active orangehrm-firstname\"]"));
    public static Target SEGUNDO_NOMBRE = Target.the("Opción PIM").located(By.xpath("//*[@class=\"oxd-input oxd-input--active orangehrm-middlename\"]"));
    public static Target NOMBRE = Target.the("Opción PIM").located(By.xpath("//*[@class=\"oxd-input oxd-input--active orangehrm-lastname\"]"));
    public static Target CHECK = Target.the("Opción PIM").located(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/input"));

    public static Target CREATE_LOGIN_DETAILS = Target.the("Create Login Details toggle")
            .located(By.xpath("//p[normalize-space()='Create Login Details']/following::span[1]"));
    public static Target EMPLOYEE_USERNAME = Target.the("Employee username")
            .located(By.xpath("//label[normalize-space()='Username']/../following-sibling::div//input"));
    public static Target EMPLOYEE_PASSWORD = Target.the("Employee password")
            .located(By.xpath("//label[normalize-space()='Password']/../following-sibling::div//input"));
    public static Target EMPLOYEE_CONFIRM_PASSWORD = Target.the("Employee confirm password")
            .located(By.xpath("//label[normalize-space()='Confirm Password']/../following-sibling::div//input"));
    public static Target SAVE_BUTTON = Target.the("Save button")
            .located(By.xpath("//button[normalize-space()='Save']"));

    public static Target EMPLOYEE_NAME_SEARCH = Target.the("Employee name search")
            .located(By.xpath("//label[normalize-space()='Employee Name']/../following-sibling::div//input"));
    public static Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.xpath("//button[normalize-space()='Search']"));

    public static Target EMPLOYEE_ROW_FIRST = Target.the("Employee first row")
            .locatedBy("(//*[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[3])[1]");
    public static Target EMPLOYEE_RESULT = Target.the("Employee result")
            .locatedBy("(//*[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[3]/div[1])[1]");
    public static Target EMPLOYEE_LAST_NAME_FIRST = Target.the("Employee last name first row")
            .locatedBy("(//*[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[4])[1]");
}
