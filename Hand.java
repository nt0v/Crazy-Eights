// FullName: Panagiotis Ntovonis | AM: 5314

import java.util.ArrayList;
import java.util.HashMap;

class Hand {

    private ArrayList<Card> cardsOnHand = new ArrayList<Card>();
    private HashMap<String,Integer> cardsPerColor;
    private String[] colors = {"C","D","H","S"};

    // Constructor
    public Hand() {
        cardsPerColor = new HashMap<String,Integer>();
        for (int i = 0; i < colors.length; i++) {
            cardsPerColor.put(colors[i],0);
        }
    }

    // Public Method | addCard
    public void addCard(Card card) {
        cardsOnHand.add(card);
        cardsPerColor.put(card.getSuit(),cardsPerColor.get(card.getSuit())+1);
    }

    // Public Method | removeCard
    public void removeCard(Card card) {
        cardsOnHand.remove(card);
        cardsPerColor.put(card.getSuit(),cardsPerColor.get(card.getSuit())-1);
    }

    // Public Method | getCard
    public Card getCard(int index) {
        return cardsOnHand.get(index);
    }

    // Public Method | printHand
    public void printHand() {
        for (int i = 0; i < cardsOnHand.size(); i++) {
            System.out.print(" " + i + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < cardsOnHand.size(); i++) {
            System.out.print(cardsOnHand.get(i) + " ");
        }
    }

    // Public Method | isEmpty
    public boolean isEmpty() {
        return cardsOnHand.size() == 0;
    }

    // Extra Method | Finds Max Value in the HashMap
    public String maxValueInHashMap() {
        int max = 0;
        String maxColor = "";
        for (int i = 0; i < colors.length; i++) {
            if (cardsPerColor.get(colors[i]) > max) {
                max = cardsPerColor.get(colors[i]);
                maxColor = colors[i];
            }
        }
        return maxColor;
    }

    // Public Method | findMatchingCard
    public Card findMatchingCard(Card card) {
        for (int i = 0; i < cardsOnHand.size(); i++) {
            if (cardsOnHand.get(i).matches(card) && cardsOnHand.get(i).getNumber() != 8) {
                return cardsOnHand.get(i);
            }
        }
        for (int i = 0; i < cardsOnHand.size(); i++) {
            if (cardsOnHand.get(i).getNumber() == 8) {
                cardsOnHand.get(i).setSuit(maxValueInHashMap());
                return cardsOnHand.get(i);
            }
        }
        return null;
    }

    // Main Method
    public static void main(String[] args) {
        Card card1 = new Card(1,"H");
        Card card2 = new Card(2,"D");
        Card card3 = new Card(3,"C");
        Card card4 = new Card(4,"S");
        Card card5 = new Card(5,"H");
        Hand hand = new Hand();
        hand.addCard(card1);
        hand.addCard(card2);
        hand.removeCard(card1);
        hand.printHand();
        hand.addCard(card1);
        hand.addCard(card3);
        hand.addCard(card4);
        hand.addCard(card5);
        System.out.println("\n");
        hand.printHand();
        Card cardToMatch = new Card(9,"D");
        System.out.println("\nMatching Card: " + hand.findMatchingCard(cardToMatch));
        Card cardToMatch1 = new Card(8,"D");
        System.out.println("\nMatching Card: " + hand.findMatchingCard(cardToMatch1));
    }

}