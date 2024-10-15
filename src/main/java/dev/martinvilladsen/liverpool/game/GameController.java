package dev.martinvilladsen.liverpool.game;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
          throw new GameNotFoundException();
        }
        return game.get();
    }

    // Post
    @ResponseStatus(HttpStatus.CREATED) // Sender en 201 hvis post request bliver gennemført
    @PostMapping("")
    void create(@Valid @RequestBody Game game) {
        gameRepository.create(game);
    }

    // Put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Game game, @PathVariable int id) {
        gameRepository.update(game, id);
    }

    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        gameRepository.delete(id);
    }




}
