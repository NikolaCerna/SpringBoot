package sk.ukf.demo.format;

import org.springframework.stereotype.Component;

@Component("plainText")
public class PlainText implements MessageFormatter {

    public String format(String message) {
        return message;
    }
}
