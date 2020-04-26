package poker.actions;

import poker.GameState;
import poker.GameState.Phase;
import poker.Player;
import java.util.*;

public class AddAnte extends Action<Map<Player, Integer>> {

  public AddAnte(Map<Player, Integer> args) {
    super(Type.AddPlayers, args, new HashSet<>(Arrays.asList(Phase.PreAnte)));
  }

  public GameState run(GameState game, Map<Player, Integer> args) {
    if (!this.allowedPhases.contains(game.phase)) {
      throw new IllegalStateException("Action " + this.type + " only runnable in " + this.allowedPhases);
    }
    Map<Player, Integer> ante = (Map<Player, Integer>) args;
    List<Player> players = new ArrayList<Player>();

    // filter -> map
    int potAdditions = 0;
    for (Player p : game.players) {
      if (ante.keySet().contains(p)) {
        potAdditions += ante.get(p);
        players.add(new Player(p.hand, p.name, p.wallet - ante.get(p)));
      } else {
        players.add(new Player(p.hand, p.name, p.wallet));
      }
    }

    return new GameState(game.deck, players, game.phase, game.pot + potAdditions);
  }
}