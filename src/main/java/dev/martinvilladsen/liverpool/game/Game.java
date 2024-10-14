package dev.martinvilladsen.liverpool.game;

import java.time.LocalDateTime;

public class Game {

    private static int id;
    private String opponent;
    private LocalDateTime gameStart;
    private LocalDateTime gameEnd;
    private Location location;


    public Game(String opponent, LocalDateTime gameStart, LocalDateTime gameEnd, Location location) {
        id += 1;
        this.opponent = opponent;
        this.gameStart = gameStart;
        this.gameEnd = gameEnd;
        this.location = location;
    }

    public static int getId() {
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
