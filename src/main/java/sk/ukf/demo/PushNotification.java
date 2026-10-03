package sk.ukf.demo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sk.ukf.demo.format.MessageFormatter;

@Component("pushNotification")
public class PushNotification implements NotificationService {

    private final MessageFormatter messageFormatter;

    public PushNotification(@Qualifier("upperCase") MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    @Override
    public String send(String message) {
        String formattedMessage = messageFormatter.format(message);
        return "Posielam notifikáciu push-om: " + formattedMessage;
    }

}
