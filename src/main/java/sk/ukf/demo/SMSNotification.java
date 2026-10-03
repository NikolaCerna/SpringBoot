package sk.ukf.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sk.ukf.demo.format.MessageFormatter;

@Component("smsNotification")
class SMSNotification implements NotificationService {

    private final MessageFormatter messageFormatter;

    public SMSNotification(@Qualifier("plainText") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }
    @Override
    public String send(String message) {
        String formattedMessage = messageFormatter.format(message);
        return "Posielam notifikáciu sms-kou: " + formattedMessage;
    }

}
