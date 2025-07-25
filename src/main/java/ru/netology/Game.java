package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<Player>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.name == name) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Elemet whis name " + player1 + " not registered");

        }
        if (player2 == null) {
            throw new NotRegisteredException("Elemet whis name " + player2 + " not registered");

        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;

        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;


    }

}
