package poker;

import java.util.*;

public class Game {
  public static void main(String[] args) {
    Player p1 = Player.create("Felix", 100);
    Player p2 = Player.create("Albert", 100);
    List<Player> players = new ArrayList<Player>(List.of(p1, p2));
    GameState game = GameState.create(players);
    System.out.println(game);
  }
}