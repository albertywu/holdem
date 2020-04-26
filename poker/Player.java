package poker;

import java.util.*;

public class Player {
  public final Hand hand;
  public final String name;
  public final int wallet; // in cents, or smallest monetary denomination

  public Player(Hand hand, String name, int wallet) {
    this.hand = hand;
    this.name = name;
    this.wallet = wallet;
  }

  public static Player create(String name, int wallet) {
    Map<Card, Boolean> visibility = new HashMap<Card, Boolean>();
    List<Card> cards = new ArrayList<Card>();
    Hand hand = new Hand(cards, visibility);
    return new Player(hand, name, wallet);
  }

  public static class Hand {
    public final List<Card> cards;
    public final Map<Card, Boolean> visibility;

    public Hand(List<Card> cards, Map<Card, Boolean> visibility) {
      this.cards = cards;
      this.visibility = visibility;
    }
  }

  @Override
  public String toString() {
    return this.name + " [" + this.wallet + "]";
  }
}