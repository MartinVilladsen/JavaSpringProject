package dev.martinvilladsen.liverpool.game;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {

    private List<Game> games = new ArrayList<>();

    private final JdbcClient jdbcClient;

    public GameRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Game> findAll() {
        return jdbcClient.sql("select * from game").query(Game.class).list();
    }

    public Optional<Game> findById(int id) {
        return jdbcClient.sql("SELECT id, opponent, gameStart, gameEnd, location FROM Game WHERE id = :id")
                .param("id", id)
                .query(Game.class)
                .optional();
    }

    public void create(Game game) {
        var updated = jdbcClient.sql("INSERT INTO Game(id, opponent, gameStart, gameEnd, location) values(?,?,?,?,?)")
                .params(List.of(game.getId(), game.getOpponent(), game.getGameStart(), game.getGameEnd(), game.getLocation().name()))
                .update();

        Assert.state(updated == 1, "failed to create Game vs " + game.getOpponent());
    }
    public void update(Game game, int id) {
        var updated = jdbcClient.sql("update game set opponent = ?, gameStart = ?, gameEnd = ?, location = ? where id = ?")
                .params(List.of(game.getId(), game.getOpponent(), game.getGameStart(), game.getGameEnd(), game.getLocation().name(), id))
                .update();

        Assert.state(updated == 1, "failed to update Game vs " + game.getOpponent());
    }

    public void delete(int id) {
        var updated = jdbcClient.sql("delete from game where id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "failed to delete Game " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from game").query().listOfRows().size();
    }

    public void saveAll(List<Game> games) {
        games.stream().forEach(this::create);
    }

    public List<Game> findByLocation(String location) {
        return jdbcClient.sql("select * from game where location = :location")
                .param("location", location)
                .query(Game.class)
                .list();
    }

}

/**
 * List<Game> findAll() {
 *         return games;
 *     }
 *
 *     Optional<Game> findbyId(int id) {
 *         return games.stream().filter(game -> game.getId() == id).findFirst();
 *     }
 *
 *     void create(Game game) {
 *         games.add(game);
 *     }
 *
 *     // Put
 *     void update(Game game, int id) {
 *         Optional<Game> existingGame = findbyId(id);
 *         if (existingGame.isPresent()) {
 *             games.set(games.indexOf(existingGame.get()), game);
 *         }
 *     }
 *
 *     // Delete
 *     void delete(int id) {
 *         games.removeIf(game -> game.getId() == id);
 *     }
 *
 *     @PostConstruct
 *     private void init() {
 *         games.add(new Game(1, "Manchester United", LocalDateTime.now(),
 *                 LocalDateTime.now().plusMinutes(90), Location.Home));
 *
 *         games.add(new Game(2, "Arsenal FC", LocalDateTime.now().plusDays(1),
 *                 LocalDateTime.now().plusDays(1).plusMinutes(90), Location.Away));
 *
 *         games.add(new Game(3, "West Ham United", LocalDateTime.now().plusDays(2),
 *                 LocalDateTime.now().plusDays(2).plusMinutes(90), Location.Home));
 *
 *     }
 */
