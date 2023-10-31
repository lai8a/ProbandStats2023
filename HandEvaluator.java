
/**--------------------------------------------------------------------
 * Evaluates set of cards, similar to Monte Carlo simulation.
 * 
 * @author Laiba Khan, CSCI3327 Probability and Applied Statistics
 * 10/30/2023
 * 
 * Mini Programming Project
 * StatsLibrary: HandEvaluator
 --------------------------------------------------------------------
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + suit;
    }
}

class HandEvaluator {
    private List<Card> deck;
    private List<Card> hand;

    public HandEvaluator() {
        //Initialize the deck with 52 cards.
        initializeDeck();
        //Initialize hand as empty.
        hand = new ArrayList<>();
    }

    private void initializeDeck() {
        //Create a standard deck of 52 cards with four suits 
        //(Hearts, Diamonds, Clubs, Spades) and 13 ranks (2 to Ace).
        deck = new ArrayList<>();
        String[] suits = {"H", "D", "C", "S"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public Card drawCard() {
        if (!deck.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(deck.size());
            Card drawnCard = deck.remove(index);
            return drawnCard;
        } else {
        //No cards left in the deck. Return null.
            return null; 
        }
    }

    public List<Card> drawHand(int handSize) {
        if (handSize <= 0) {
            //Not a valid hand size.
            return null; 
        }

        List<Card> drawnHand = new ArrayList<>();
        for (int i = 0; i < handSize; i++) {
            Card drawnCard = drawCard();
            if (drawnCard != null) {
                drawnHand.add(drawnCard);
            } else {
                //Break when no more cards in the deck.
                break; 
            }
        }
        return drawnHand;
    }

    //Calculate the probability of getting a pair in a hand.
    public double evaluatePairProbability(int numHands) {
        int pairCount = 0;
        for (int i = 0; i < numHands; i++) {
            List<Card> currentHand = drawHand(5);
            if (hasPair(currentHand)) {
                pairCount++;
            }
        }
        return (double) pairCount / numHands;
    }


    private boolean hasPair(List<Card> hand) {
        //Implementation for checking a pair in the hand.
        List<String> ranks = new ArrayList<>();
        for (Card card : hand) {
            String rank = card.getRank();
            if (ranks.contains(rank)) {
                return true;
            }
            ranks.add(rank);
        }
        return false;
    }

    public double evaluateThreeOfAKindProbability(int numHands) {
        int threeOfAKindCount = 0;
        for (int i = 0; i < numHands; i++) {
            List<Card> currentHand = drawHand(5);
            if (hasThreeOfAKind(currentHand)) {
                threeOfAKindCount++;
            }
        }
        return (double) threeOfAKindCount / numHands;
    }

    public double evaluateFourOfAKindProbability(int numHands) {
        int fourOfAKindCount = 0;
        for (int i = 0; i < numHands; i++) {
            List<Card> currentHand = drawHand(5);
            if (hasFourOfAKind(currentHand)) {
                fourOfAKindCount++;
            }
        }
        return (double) fourOfAKindCount / numHands;
    }

    public double evaluateStraightProbability(int numHands) {
        int straightCount = 0;
        for (int i = 0; i < numHands; i++) {
            List<Card> currentHand = drawHand(5);
            if (hasStraight(currentHand)) {
                straightCount++;
            }
        }
        return (double) straightCount / numHands;
    }

    public double evaluateFlushProbability(int numHands) {
        int flushCount = 0;
        for (int i = 0; i < numHands; i++) {
            List<Card> currentHand = drawHand(5);
            if (hasFlush(currentHand)) {
                flushCount++;
            }
        }
        return (double) flushCount / numHands;
    }

    public double evaluateFullHouseProbability(int numHands) {
        int fullHouseCount = 0;
        for (int i = 0; i < numHands; i++) {
            List<Card> currentHand = drawHand(5);
            if (hasFullHouse(currentHand)) {
                fullHouseCount++;
            }
        }
        return (double) fullHouseCount / numHands;
    }

    public double evaluateStraightFlushProbability(int numHands) {
        int straightFlushCount = 0;
        for (int i = 0; i < numHands; i++) {
            List<Card> currentHand = drawHand(5);
            if (hasStraightFlush(currentHand)) {
                straightFlushCount++;
            }
        }
        return (double) straightFlushCount / numHands;
    }

    public double evaluateRoyalFlushProbability(int numHands) {
        int royalFlushCount = 0;
        for (int i = 0; i < numHands; i++) {
            List<Card> currentHand = drawHand(5);
            if (hasRoyalFlush(currentHand)) {
                royalFlushCount++;
            }
        }
        return (double) royalFlushCount / numHands;
    }
//-----------------------------------------------------------------------
//Did not finish these due to time constraints:
//-----------------------------------------------------------------------
private boolean hasThreeOfAKind(List<Card> hand) {
        //Detect if three of a kind.
        
        return false;
    }

    private boolean hasFourOfAKind(List<Card> hand) {
        //Detect if four of a kind.
        return false;
    }

    private boolean hasStraight(List<Card> hand) {
        //Detect if straight.
        return false;
    }

    private boolean hasFlush(List<Card> hand) {
        //Detect if flush.
        return false;
    }

    private boolean hasFullHouse(List<Card> hand) {
        //Detect if full house.
        return false;
    }

    private boolean hasStraightFlush(List<Card> hand) {
        //Detect if straight flush.
        return false;
    }

    private boolean hasRoyalFlush(List<Card> hand) {
        //Detect if royal flush.
        return false;
    }
}
