package com.golf_hdcp.mhghexp.repository;

import com.golf_hdcp.mhghexp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByPlayerName(String playerName);
}
