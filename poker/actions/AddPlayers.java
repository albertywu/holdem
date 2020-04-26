package poker.actions;

import poker.GameState;
import poker.GameState.Phase;
import poker.Player;
import java.util.*;
import poker.Util;

public class AddPlayers extends Action<List<Player>> {

  public AddPlayers(List<Player> args) {
    super(Type.AddPlayers, args, new HashSet<>(Arrays.asList(Phase.PreAnte)));
  }

  public GameState run(GameState game, List<Player> args) {
    if (!this.allowedPhases.contains(game.phase)) {
      throw new IllegalStateException("Action " + this.type + " only runnable in " + this.allowedPhases);
    }
    List<Player> players = (List<Player>) args;
    return new GameState(game.deck, Util.concat(game.players, players), game.phase, game.pot);
  }
}