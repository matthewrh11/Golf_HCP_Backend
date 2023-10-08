package com.golf_hdcp.mhghexp.service;

import com.golf_hdcp.mhghexp.model.Player;
import com.golf_hdcp.mhghexp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long playerId) {
        return playerRepository.findById(playerId);
    }

    public Optional<Player> getPlayerByName(String playerName) {
        return playerRepository.findByPlayerName(playerName);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long playerId, Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findById(playerId);

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setPlayerName(updatedPlayer.getPlayerName());
            playerToUpdate.setHandicap(updatedPlayer.getHandicap());
            return playerRepository.save(playerToUpdate);
        }

        return null; // Handle the case where the player with the given ID is not found.
    }

    public void deletePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
    }
}
