import org.junit.Test;
import java.time.LocalDateTime;

/** Класс формирования письма*/
public class NewMessageTest extends BaseGmailTest{
    private final static String subject = "Проверка от "+ LocalDateTime.now();
    private final static String recipient = "Recipient_email@gmail.com";
    private final static String messageText = "Здравствуйте, направляю вам проверочное письмо!";

    /** Метод формирования письма и проверки его в отправленных письмах*/
    @Test
    public void createMessage_messageGeneration_sendingMessage(){
        NewMessage newMessage = new NewMessage(recipient, subject, messageText);
        newMessage.userCanComposeEmail();
        newMessage.CheckMessage();
    }
}
