package poker;

import java.util.*;

public class Game {
  public static void main(String[] args) {
    List<Card> cards = new ArrayList<Card>();
    for (int rank = 2; rank <= 14; rank++) {
      cards.add(new Card(rank, Suit.Diamond));
      cards.add(new Card(rank, Suit.Club));
      cards.add(new Card(rank, Suit.Heart));
      cards.add(new Card(rank, Suit.Spade));
    }
    Deck deck = new Deck(cards);
    System.out.println("Welcome to Texas Hold'em!");
    System.out.println("Here is your deck: " + deck);

    System.out.println("Pulling top 3 cards...");
    Tuple<List<Card>, Deck> pull = deck.pull(3);
    System.out.println("3 cards pulled: " + pull.x);
    deck = pull.y;
    System.out.println("New deck: " + deck);
  }
}