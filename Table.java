// FullName: Panagiotis Ntovonis | AM: 5314

import java.util.ArrayList;

class Table {

    private Pile pile = new Pile();
    private ArrayList<Card> cardsOnTable = new ArrayList<Card>();
    private Card topCard;

    // Constructor
    public Table() {
        pile.fill();
        topCard = pile.nextCard();
        cardsOnTable.add(topCard);
    }

    // Accessor Method | topCard
    public Card getTopCard() {
        return topCard;
    }

    // Public Method | throwCard
    public void throwCard(Card card) {
        cardsOnTable.add(card);
        topCard = card;
    }

    // Public Method | drawCard
    public Card drawCard() {
        if (!pile.isEmpty()) {
            return pile.nextCard();
        }
        else {
            pile.fill(cardsOnTable);
            return pile.nextCard();
        }
    }

    // Public Method | print
    public void print() {
        for (int i = 0; i < cardsOnTable.size(); i++) {
            System.out.println(cardsOnTable.get(i));
        }
    }

    // Main Method
    public static void main(String[] args) {
        Table table = new Table();
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            Card card = new Card(i,"H");
            cards.add(card);
        }
        for (int i = 0; i < 45; i++) {
            table.drawCard();
        }
        for (int i = 0; i < 4; i++) {
            table.throwCard(cards.get(i));
            System.out.println(table.getTopCard());
        }
    }

}