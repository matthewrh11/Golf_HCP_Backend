package com.golf_hdcp.mhghexp.controller;

import java.util.List;
import java.util.Optional; // Import for Optional
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.golf_hdcp.mhghexp.model.Player; // Import for Player
import com.golf_hdcp.mhghexp.service.PlayerService; // Import for PlayerService
import com.golf_hdcp.mhghexp.model.GolfScore;
import com.golf_hdcp.mhghexp.service.GolfScoreService;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/scores")
public class GolfScoreController {

    private final GolfScoreService golfScoreService;
    private final PlayerService playerService;

    public GolfScoreController(GolfScoreService golfScoreService, PlayerService playerService) {
        this.golfScoreService = golfScoreService;
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<GolfScore>> getAllGolfScores() {
        List<GolfScore> golfScores = golfScoreService.getAllGolfScores();
        return new ResponseEntity<>(golfScores, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GolfScore> createGolfScore(@RequestBody GolfScore golfScore) {
        // Check if the player associated with the golfScore exists in the database
        Optional<Player> existingPlayer = playerService.getPlayerByName(golfScore.getPlayer().getPlayerName());

        if (existingPlayer.isPresent()) {
            // Use the existing player
            golfScore.setPlayer(existingPlayer.get());
        } else {
            // If the player doesn't exist, create and save it first
            Player newPlayer = playerService.createPlayer(golfScore.getPlayer());
            golfScore.setPlayer(newPlayer);
        }

        // Now, you can save the GolfScore entity
        GolfScore savedScore = golfScoreService.createGolfScore(golfScore);
        return new ResponseEntity<>(savedScore, HttpStatus.CREATED);
    }

    @GetMapping("/{playerName}")
    public ResponseEntity<List<GolfScore>> getGolfScoresByPlayerName(@PathVariable String playerName) {
        List<GolfScore> golfScores = golfScoreService.getGolfScoresByPlayerName(playerName);
        return new ResponseEntity<>(golfScores, HttpStatus.OK);
    }
}
