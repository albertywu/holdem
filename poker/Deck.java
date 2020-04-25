package poker;

import java.util.*;

public class Deck {
  public final List<Card> cards;

  public static List<Card> shuffle(List<Card> cards) {
    // TODO: implement
    return cards;
  }

  public Deck(List<Card> cards) {
    this.cards = shuffle(cards);
  }

  // pulls n cards from top of deck, returns cards and a new deck
  public Pair<List<Card>, Deck> pull(int n) {
    return new Pair<List<Card>, Deck>(this.cards.subList(0, n), new Deck(this.cards.subList(n, this.cards.size())));
  }

  @Override
  public String toString() {
    String s = "";
    for (Card card : this.cards) {
      s = s + card.toString() + " ";
    }
    return s;
  }
}