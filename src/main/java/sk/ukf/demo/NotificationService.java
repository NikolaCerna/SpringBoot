package sk.ukf.demo;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
    String send(String message);
}