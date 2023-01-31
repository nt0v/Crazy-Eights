// FullName: Panagiotis Ntovonis | AM: 5314

import java.util.ArrayList;
import java.util.Random;

class Pile {

    private ArrayList<Card> cards = new ArrayList<Card>();
    private String[] colors = {"C","D","H","S"};

    // Public Method | fill
    public void fill() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < colors.length; j++) {
                Card newCard = new Card(i,colors[j]);
                cards.add(newCard);
            }
        }
        shuffle(cards);
    }

    // Public Method | fill (overloaded)
    public void fill(ArrayList<Card> thrownCards) {
        for (int i = 0; i < thrownCards.size(); i++) {
            cards.add(thrownCards.get(i));
        }
        shuffle(cards);
    }

    // Extra Method | Count How Many Times a Number Appears on a List | Used in shuffle Method
    public int countHowManyTimes(int n,ArrayList<Integer> list) {
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n) {
                counter++;
            }
        }
        return counter;
    }

    // Private Method | shuffle
    private void shuffle(ArrayList<Card> list) {
        Random rnd = new Random();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Card> list2 = new ArrayList<Card>();
        int counter = 0;
        while (counter < cards.size()) {
            int randomInt = rnd.nextInt(cards.size());
            if (countHowManyTimes(randomInt,list1) < 1) {
                list1.add(randomInt);
                counter++;
            }
        }
        for (int i = 0; i < cards.size(); i++) {
            list2.add(cards.get(list1.get(i)));
        }
        for (int i = 0; i < cards.size(); i++) {
            cards.set(i,list2.get(i));
        }
    }

    // Public Method | nextCard
    public Card nextCard() {
        Card cardToReturn = cards.get(cards.size()-1);
        cards.remove(cardToReturn);
        return cardToReturn;
    }

    // Public Method | isEmpty
    public boolean isEmpty() {
        return cards.size() == 0;
    }

    // Public Method | print
    public void print() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i) + " ");
        }
    }

    // Main Method
    public static void main(String[] args) {
        Pile pile1 = new Pile();
        pile1.fill();
        Pile pile2 = new Pile();
        ArrayList<Card> list = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            Card card = new Card(i,"H");
            list.add(card);
        }
        pile2.fill(list);
        pile1.print();
        System.out.print("\n");
        pile2.print();
        System.out.print("\n");
        System.out.println(pile1.nextCard());
        System.out.println(pile2.nextCard());
        System.out.println(pile1.isEmpty());
        System.out.println(pile2.isEmpty());
        Pile pile3 = new Pile();
        System.out.println(pile3.isEmpty());
    }

}