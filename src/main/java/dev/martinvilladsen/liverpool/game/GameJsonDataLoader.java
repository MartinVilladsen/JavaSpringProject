package dev.martinvilladsen.liverpool.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class GameJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(GameJsonDataLoader.class);
    private final GameRepository gameRepository;
    private final ObjectMapper objectMapper;

    public GameJsonDataLoader(GameRepository gameRepository, ObjectMapper objectMapper) {
        this.gameRepository = gameRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (gameRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/games.json")) {
                Games allGames = objectMapper.readValue(inputStream, Games.class);
                gameRepository.saveAll(allGames.getGames());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data " + e);
            }
        } else {
            log.info("Not loading Games from JSON data because the collection already contains data");
        }
    }
}
