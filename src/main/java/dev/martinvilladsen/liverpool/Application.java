package dev.martinvilladsen.liverpool;

import dev.martinvilladsen.liverpool.game.Game;
import dev.martinvilladsen.liverpool.game.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner game() {
		return args -> {
			Game game = new Game(4, "Manchester City", LocalDateTime.now(),
					LocalDateTime.now().plusMinutes(90), Location.Home);
			log.info("Game: " + game);
		};
	}



}
