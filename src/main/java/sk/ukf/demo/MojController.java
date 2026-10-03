package sk.ukf.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MojController {
    private final NotificationService smsService;
    private final NotificationService emailService;
    private final NotificationService pushService;

    public MojController(@Qualifier("smsNotification") NotificationService smsService,
                         @Qualifier("emailNotification") NotificationService emailService,
                         @Qualifier("pushNotification")  NotificationService pushService){
        this.smsService = smsService;
        this.emailService = emailService;
        this.pushService = pushService;
    }

    @GetMapping("/notify/email")
    public String sendEmail() {
        return emailService.send("Používateľ sa prihlásil.");
    }

    @GetMapping("/notify/push")
    public String sendPush() {
        return pushService.send("Používateľ sa prihlásil.");
    }

    @GetMapping("/notify/sms")
    public String sendSms() {
        return smsService.send("Používateľ sa prihlásil.");
    }
}
