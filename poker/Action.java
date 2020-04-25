package poker;

import java.util.*;

public class Action {
  enum Type {
    Ante, AddPlayers, RemovePlayer, DrawCards, FlopFlip, TurnFlip, RiverFlip, ShowdownFlip
  }

  public final Type type;
  public final Object args;

  public Action(Type type, Object args) {
    this.type = type;
    this.args = args;
  }

  public static GameState addPlayers(GameState game, List<Player> players) {
    return new GameState(game.deck, Utils.concat(game.players, players), game.phase, game.pot);
  }

  public static GameState addAnte(GameState game, Map<Player, Integer> ante) {
    List<Player> players = new ArrayList<Player>();

    // filter -> map
    int potAdditions = 0;
    for (Player p : game.players) {
      if (ante.keySet().contains(p)) {
        potAdditions += ante.get(p);
        players.add(new Player(p.hand, p.name, p.wallet - ante.get(p)));
      }
    }

    return new GameState(game.deck, players, game.phase, game.pot + potAdditions);
  }
}
