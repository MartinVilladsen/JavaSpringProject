package dev.martinvilladsen.liverpool.game;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {

    private List<Game> games = new ArrayList<>();

    List<Game> findAll() {
        return games;
    }

    Optional<Game> findbyId(int id) {
        return games.stream().filter(game -> game.getId() == id).findFirst();
    }

    void create(Game game) {
        games.add(game);
    }

    @PostConstruct
    private void init() {
        games.add(new Game(1, "Manchester United", LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(90), Location.Home));

        games.add(new Game(2, "Arsenal FC", LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusMinutes(90), Location.Away));

        games.add(new Game(3, "West Ham United", LocalDateTime.now().plusDays(2),
                LocalDateTime.now().plusDays(2).plusMinutes(90), Location.Home));

    }

}
