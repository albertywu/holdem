package poker.actions;

import java.util.*;
import poker.GameState;

public abstract class Action {
  public enum Type {
    AddAnte, AddPlayers, RemovePlayer, DrawCards, FlopFlip, TurnFlip, RiverFlip, ShowdownFlip
  }

  public final Type type;
  public final Object args;
  public final Set<GameState.Phase> allowedPhases;

  public Action(Type type, Object args, Set<GameState.Phase> allowedPhases) {
    this.type = type;
    this.args = args;
    this.allowedPhases = allowedPhases;
  }

  public abstract GameState run(GameState game, Object args);
}
