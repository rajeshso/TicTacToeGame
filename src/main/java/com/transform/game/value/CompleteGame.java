package com.transform.game.value;

/**
 * Created by Rajesh on 30-Apr-17.
 */
public class CompleteGame {
    private String id;
    private String player;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPlayer() {
        return player;
    }
    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "CompleteGame{" +
                "id='" + id + '\'' +
                ", player='" + player + '\'' +
                '}';
    }
}
