package dev.martinvilladsen.liverpool.game;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class Game {

    @Positive
    private int id;
    @NotEmpty
    private String opponent;
    private LocalDateTime gameStart;
    private LocalDateTime gameEnd;
    private Location location;


    public Game(int id, String opponent, LocalDateTime gameStart, LocalDateTime gameEnd, Location location) {
        if (!gameEnd.isAfter(gameStart)) {
            throw new IllegalArgumentException("Game End must be after Game Start");
        }
        this.id = id;
        this.opponent = opponent;
        this.gameStart = gameStart;
        this.gameEnd = gameEnd;
        this.location = location;
    }


    public int getId() {
        return id;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public LocalDateTime getGameStart() {
        return gameStart;
    }

    public void setGameStart(LocalDateTime gameStart) {
        this.gameStart = gameStart;
    }

    public LocalDateTime getGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(LocalDateTime gameEnd) {
        this.gameEnd = gameEnd;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Game{" +
                "opponent='" + opponent + '\'' +
                ", gameStart=" + gameStart +
                ", gameEnd=" + gameEnd +
                ", location=" + location +
                '}';
    }
}
