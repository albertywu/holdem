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

  @Override
  public String toString() {
    String rank = String.valueOf(this.rank);
    if (this.rank == 11)
      rank = "J";
    if (this.rank == 12)
      rank = "Q";
    if (this.rank == 13)
      rank = "K";
    if (this.rank == 14)
      rank = "A";
    String suit = "";
    if (this.suit == Suit.Diamond) {
      suit = "D";
    } else if (this.suit == Suit.Club) {
      suit = "C";
    } else if (this.suit == Suit.Heart) {
      suit = "H";
    } else if (this.suit == Suit.Spade) {
      suit = "S";
    }
    return rank + suit;
  }
}