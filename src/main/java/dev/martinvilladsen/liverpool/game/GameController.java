package dev.martinvilladsen.liverpool.game;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameRepository gameRepository;


    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Get
    @GetMapping("")
    List<Game> findAll() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    Game findById(@PathVariable Integer id) {
        Optional<Game> game = gameRepository.findbyId(id);
        if (game.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return game.get();
    }

    // Post
    @ResponseStatus(HttpStatus.CREATED) // Sender en 201 hvis post request bliver gennemført
    @PostMapping("")
    void create(@RequestBody Game game) {
        gameRepository.create(game);
    }

    // Put

    // Delete




}
