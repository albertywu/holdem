package poker;

enum Suit {
  Diamond, Club, Heart, Spade
}

public class Card implements Comparable<Card> {
  public final int rank;
  public final Suit suit;

  public Card(int rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  @Override
  public int compareTo(Card c) {
    return this.rank - c.rank;
  }
}