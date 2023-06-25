import org.junit.Test;
import java.time.LocalDateTime;

import static com.codeborne.selenide.Selenide.sleep;

/** Класс формирования подписи, отправки и проверки письма с подписью*/
public class SettingSignatureTest extends BaseGmailTest{
    private final static String signatureName = "Подпись от "+LocalDateTime.now();
    private final static String signatureText = "С уважением, Ержан";
    private final static String subject = "Проверка от "+ LocalDateTime.now();
    private final static String recipient = "Recipient_email@gmail.com";
    private final static String messageText = "Здравствуйте, направляю вам проверочное письмо!";

    /** Метод добавления подписи, отправки и проверки письма с подписью*/
    @Test
    public void addSignature_createSignature_checkSignatureInMessage() {
        SettingsPage settingsPage= new SettingsPage(signatureName, signatureText);
        settingsPage.CreateSignature();
        settingsPage.SelectSignature();
        waitUntilPagesIsLoaded();
        NewMessage newMessage = new NewMessage(recipient, subject, messageText);
        newMessage.userCanComposeEmail();
        newMessage.CheckMessageWithSignature(signatureText);
    }

}
