package poker;

import poker.actions.Action;
import java.util.*;

/*
 * From any state of the world, call .next(action) to advance state to new state
 * state: GameState newState = state.next(action)
 */
public class GameState {
  public enum Phase {
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

  public <T> GameState run(Action<T> action, T args) {
    return action.run(this, args);
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