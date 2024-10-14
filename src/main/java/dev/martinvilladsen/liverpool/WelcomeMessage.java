package dev.martinvilladsen.liverpool;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {

    public String getWelcomeMessage() {
        return "Welcome to my Application!?";
    }

}
