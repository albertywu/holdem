package poker;

import java.util.List;
import java.util.ArrayList;

public class Deck {
  public final List<Card> cards;

  public static List<Card> shuffle(List<Card> cards) {
    // TODO: implement
    return cards;
  }

  public Deck() {
    List<Card> cards = new ArrayList<Card>();
    for (int rank = 2; rank <= 14; rank++) {
      cards.add(new Card(rank, Suit.Diamond));
      cards.add(new Card(rank, Suit.Heart));
      cards.add(new Card(rank, Suit.Club));
      cards.add(new Card(rank, Suit.Spade));
    }
    this.cards = shuffle(cards);
  }
}