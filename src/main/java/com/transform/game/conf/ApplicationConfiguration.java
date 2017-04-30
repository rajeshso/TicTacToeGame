package com.transform.game.conf;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rajesh on 29-Apr-17.
 */
public class ApplicationConfiguration {
    private static Set<String> playerIds = new HashSet<>(10);
    static {
        fillPlayers();
    }
    private static void fillPlayers() {
        playerIds.add("A");
        playerIds.add("B");
        playerIds.add("C");
        playerIds.add("D");
        playerIds.add("E");
        playerIds.add("F");
    }
    public static Set<String> getPlayerIds() {
        return new HashSet<>(playerIds);
    }
    public static boolean containsPlayerId(String player) {
        return playerIds.contains(player);
    }
}

