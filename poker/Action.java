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

  @SuppressWarnings({ "unchecked" }) // TODO: how to avoid unchecked warnings in a type-safe way?
  public GameState run(GameState game, Object args) {
    switch (this.type) {
      case Ante:
        Map<Player, Integer> ante = (Map<Player, Integer>) args;
        return addAnte(game, ante);
      case AddPlayers:
        List<Player> players = (List<Player>) args;
        return addPlayers(game, players);
      default:
        throw new IllegalStateException("Allowed game phases: PreDeal");
    }
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
      } else {
        players.add(new Player(p.hand, p.name, p.wallet));
      }
    }

    return new GameState(game.deck, players, game.phase, game.pot + potAdditions);
  }
}
