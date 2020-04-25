package poker;

import java.util.*;

/*
 * From any state of the world, call .next(action) to advance state to new state
 * state: GameState newState = state.next(action)
 */
public class GameState {
  enum Phase {
    PreAnte, PreDeal, PreFlop, PreTurn, PreRiver, PreShowdown
  }

  public final Deck deck;
  public final List<Player> players;
  public final Phase phase;
  public final int pot;

  public GameState(Deck deck, List<Player> players, Phase phase, int pot) {
    this.deck = deck;
    this.players = players;
    this.phase = phase;
    this.pot = pot;
  }

  @SuppressWarnings({ "unchecked" }) // TODO: how to avoid unchecked warnings in a type-safe way?
  public GameState next(Phase phase, Action action) {
    // TODO: add more actions
    switch (phase) {
      case PreAnte:
        switch (action.type) {
          case AddPlayers:
            List<Player> players = (List<Player>) action.args;
            return Action.addPlayers(this, players);
          case Ante:
            Map<Player, Integer> ante = (Map<Player, Integer>) action.args;
            return Action.addAnte(this, ante);
          default:
            throw new IllegalStateException("Allowed actions in PreDeal phase: addPlayers, addAnte");
        }
      default:
        throw new IllegalStateException("Allowed game phases: PreDeal");
    }
  }

  public static GameState create(List<Player> players) {
    List<Card> cards = new ArrayList<Card>();
    for (int rank = 2; rank <= 14; rank++) {
      cards.add(new Card(rank, Suit.Diamond));
      cards.add(new Card(rank, Suit.Club));
      cards.add(new Card(rank, Suit.Heart));
      cards.add(new Card(rank, Suit.Spade));
    }
    Deck deck = new Deck(cards);
    return new GameState(deck, players, Phase.PreAnte, 0);
  }

  @Override
  public String toString() {
    String result = "";
    result += "phase: " + this.phase + "\n";
    result += "pot: " + this.pot + "\n";
    result += "deck: " + this.deck + "\n";
    result += "players: " + this.players + "\n";
    return result;
  }
}