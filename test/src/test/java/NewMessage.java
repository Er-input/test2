import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static junit.framework.TestCase.assertEquals;

/** Класс формирования письма*/
public class NewMessage{
    private String recipient;
    private String subject;
    private String messageText;

    /** Конструктор класса формирования письма*/
    public NewMessage(String recipient, String subject, String messageText) {
        this.recipient = recipient;
        this.subject = subject;
        this.messageText = messageText;
    }

    /** Метод формирования письма*/
    public void userCanComposeEmail() {
        $(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
        $(By.xpath("//div[@aria-label='Новое сообщение']//input")).val(recipient).pressTab();
        $(By.name("subjectbox")).val(subject).pressTab();
        $(By.xpath("//div[@aria-label='Текст письма']")).sendKeys(messageText);
        $(byText("Отправить")).click();
    }

    /** Метод проверки письма в отправленных сообщениях*/
    public void CheckMessage() {
        $(byText("Сообщение отправлено.")).should(appear);
        $(byText("Просмотреть сообщение")).click();
        assertEquals($(By.xpath(String.format("//h2[text()='%s']", subject))).text(), subject);
    }

    /** Метод проверки письма с подписью в отправленных сообщения*/
    public void CheckMessageWithSignature(String signature) {
        $(byText("Сообщение отправлено.")).should(appear);
        $(byText("Просмотреть сообщение")).click();
        assertEquals($(By.xpath("//div[@data-smartmail='gmail_signature']")).text(), signature);
    }




}



