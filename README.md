# Test Gmail.com
Требования к задаче:
1. Логин на gmail.com.
2. Отправка письма с произвольным текстом.
3. Проверка в отправленных, что письмо отправлено.
4. В настройках добавить подпись и отправить еще одно письмо.
5. В отправленных проверить, что письмо отправлено с подписью.

Requirements:
Для работы следует загрузить проект в среде разработки Intellij IDEA CE.
Установить Chrome Browser (в моем случае версия 114.0.5735.134).

Предусловия:
1. Установка Maven. Скачать MAVEN с официального сайта и разархивировать.
2. Настроить переменные среды добавлением переменной MAVEN_HOME c указанием пути разархивированной директории MAVEN.
3. Добавить в PATH %MAVEN_HOME%\bin.
4. Для отправки письма необходимо поменять значение переменной recipient на адрес получателя в файлах NewMessageTest.java и SettingSignatureTest.java.

Ход проведения тестирования:
1. Для проведения тестирования необходимо пройти в директорию проекта.
2. В пути директории ввести cmd для открытия командной строки.
3. В командной строке ввести команду mvn test -Dgmail.username=your_email@gmail.com -Dgmail.password=your_gmail_password, вместо "your_email@gmail.com" ввести адрес отправителя, а вместо "your_gmail_password" ввести пароль от учетной записи отправителя.
4. Ожидать выполнение тестирования.

Структура проекта:
1. BaseGmailTest.java - файл формирования основного класса тестирования для открытия и закрытия теста.
2. NewMessageTest.java - файл тестирования формирования нового письма и проверки письма в отправленных письмах.
3. NewMessage.java  - файл формирования нового письма.
4. SettingSignatureTest.java - файл тестирования формирования подписи к письму черех настройки почты и отправки письма с подписью.
5. SettingsPage.java - файл открытия настроек и формирования подписи к письму.

Проект сформирован для русскоязычной системы Gmail.com, т.к. привязка некоторых селекторов идет через текст.
