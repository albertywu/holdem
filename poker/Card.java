package poker;

enum Suit {
  Diamond {
    @Override
    public String toString() {
      return "\u2666";
    }
  },
  Club {
    @Override
    public String toString() {
      return "\u2663";
    }
  },
  Heart {
    @Override
    public String toString() {
      return "\u2665";
    }
  },
  Spade {
    @Override
    public String toString() {
      return "\u2660";
    }
  }
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
    return rank + suit;
  }
}