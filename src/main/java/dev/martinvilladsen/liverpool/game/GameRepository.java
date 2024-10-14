package dev.martinvilladsen.liverpool.game;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepository {

    private List<Game> games = new ArrayList<>();

    List<Game> findAll() {
        return games;
    }

    @PostConstruct
    private void init() {
        games.add(new Game("Manchester United", LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(90), Location.Home));

        games.add(new Game("Arsenal FC", LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusMinutes(90), Location.Away));

        games.add(new Game("West Ham United", LocalDateTime.now().plusDays(2),
                LocalDateTime.now().plusDays(2).plusMinutes(90), Location.Home));

    }

}
