import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/** Класс страницы с настройками почты*/
public class SettingsPage{
    private String name;
    private String text;

    /** Конструктор класса*/
    public SettingsPage(String name, String text){
        this.name = name;
        this.text = text;
    }

    /** Метод формирования подписи*/
    public void CreateSignature() {
        selectSettings();
        $(By.xpath("//button[@aria-label='Создать подпись']")).should(appear).click();
        $(By.xpath("//div[@role='dialog']//input")).val(name).pressTab().click();
        $(By.xpath("//button[@name='ok']")).click();
        $(By.xpath("//div[@aria-label='Подпись']")).sendKeys(text);
        sleep(1000);
        $(By.xpath(String.format("//span[text()='%s']", name))).click();
    }

    /** Метод выбора подписи*/
    public void SelectSignature() {
        $(By.xpath("//td[@class='r9']//div[@class='Tb']//select")).selectOption(name);
        $(By.xpath("//button[@guidedhelpid='save_changes_button']")).click();
    }

    /** Метод входа в настройки почты*/
    public void selectSettings() {
        $(By.xpath("//div[@data-tooltip='Настройки']/a[@role='button']")).click();
        $(By.xpath("//button[@aria-label='Все настройки']")).should(appear).click();
    }

}