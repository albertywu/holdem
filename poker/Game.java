package poker;

import java.util.*;

import poker.Action.Type;

public class Game {
  public static void main(String[] args) {
    // Create initial game state
    Player p1 = Player.create("Felix", 100);
    Player p2 = Player.create("Albert", 100);
    Player p3 = Player.create("Pavel", 100);
    Player p4 = Player.create("Kaha", 100);
    Player p5 = Player.create("Vinh", 100);
    List<Player> players = new ArrayList<Player>(List.of(p1, p2, p3, p4, p5));
    GameState game = GameState.create(players);
    System.out.println(game);

    Map<Player, Integer> ante = new HashMap<Player, Integer>();
    ante.put(p1, 1);
    ante.put(p2, 2);
    Action anteAction = new Action(Type.Ante, ante);
    game = anteAction.run(game, ante);

    // Perform "Ante" action, and get new game state
    System.out.println(game);
  }
}