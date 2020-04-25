package poker.actions;

import poker.GameState;
import poker.GameState.Phase;
import poker.Player;
import java.util.*;
import poker.Util;

public class AddPlayers extends Action {

  public AddPlayers(Object args) {
    super(Type.AddPlayers, args, new HashSet<>(Arrays.asList(Phase.PreAnte)));
  }

  @SuppressWarnings({ "unchecked" }) // TODO: how to avoid unchecked warnings in a type-safe way?
  public GameState run(GameState game, Object args) {
    if (!this.allowedPhases.contains(game.phase)) {
      throw new IllegalStateException("Action " + this.type + " only runnable in " + this.allowedPhases);
    }
    List<Player> players = (List<Player>) args;
    return new GameState(game.deck, Util.concat(game.players, players), game.phase, game.pot);
  }
}