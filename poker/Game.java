package poker;

import java.util.*;

import poker.actions.Action;
import poker.actions.AddAnte;
import poker.actions.AddPlayers;

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

    // Perform "AddAnte" action, and get new game state
    Map<Player, Integer> ante = new HashMap<Player, Integer>();
    ante.put(p1, 1);
    ante.put(p2, 2);
    Action anteAction = new AddAnte(ante);
    game = game.run(anteAction, ante);
    System.out.println(game);

    // Perform "AddPlayers" action, and get new game state
    Player p6 = Player.create("Veronika", 100);
    Player p7 = Player.create("Maxine", 100);
    List<Player> newPlayers = new ArrayList<Player>(List.of(p6, p7));
    Action addPlayers = new AddPlayers(newPlayers);
    game = game.run(addPlayers, newPlayers);
    System.out.println(game);
  }
}