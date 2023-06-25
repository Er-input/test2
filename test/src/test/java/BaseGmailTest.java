import com.codeborne.selenide.Selenide;
import org.junit.*;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

/** Базовый класс*/
abstract public class BaseGmailTest{
    private static String gmailUsername = System.getProperty("gmail.username", "enter-your-gmail-username");
    private static String gmailPassword = System.getProperty("gmail.password", "enter-your-gmail-password");

    /** Метод вызывающийся при создании класса*/
    @BeforeClass
    public static void openMailInbox() {
        timeout = 10000;
        baseUrl = "http://gmail.com";
        browser = "chrome";
        browserSize = "1920x1080";
        open("/");
        login();
        password();
        $(".error-msg").shouldNotBe(visible, Duration.ofSeconds(10));
    }

    /** Инкапсулированный метод ожидания элемента*/
    protected static void waitUntilPagesIsLoaded() {
        $(byText("Сохранение...")).should(disappear, Duration.ofSeconds(20));
    }

    /** Метод вызывающийся при разрушении класса*/
    @AfterClass
    public static void logout() {
        closeWebDriver();
    }

    /** Метод ввода login от учетной записи пользователя*/
    private static void login() {
        $("#identifierId").val(gmailUsername).pressEnter();
    }

    /** Метод ввода пароля от учетной записи пользователя*/
    private static void password() {
        $(By.xpath("//input[@type='password']")).val(gmailPassword).pressEnter();
    }
}