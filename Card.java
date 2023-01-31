// FullName: Ntovonis Panagiotis | AM: 5314

class Card {

    private int number;
    private String suit;

    // Constructor
    public Card(int number,String suit) {
        this.number = number;
        this.suit = suit;
    }

    // Accessor Method | number
    public int getNumber() {
        return this.number;
    }

    // Mutator Method | number
    public void setNumber(int n) {
        this.number = n;
    }

    // Accessor Method | suit
    public String getSuit() {
        return this.suit;
    }

    // Mutator Method | suit
    public void setSuit(String s) {
        this.suit = s;
    }

    // Public Method | isEight
    public boolean isEight() {
        if (this.number == 8) {
            return true;
        }
        return false;
    }

    // Public Method | matches
    public boolean matches(Card other) {
        if (this.number == other.number || (this.suit).equals(other.suit)) {
            return true;
        }
        return false;
    }

    // Public Method | toString
    public String toString() {
        return (this.number + this.suit);
    }

    // Main Method
    public static void main(String[] args) {
        Card card1 = new Card(1,"H");
        Card card2 = new Card(2,"S");
        System.out.println(card1.getSuit());
        System.out.println(card1);
        card1.setSuit("D");
        System.out.println(card1);
        System.out.println(card1.matches(card2));
        System.out.println(card2.isEight());
        Card card3 = new Card(8,"S");
        System.out.println(card3.isEight());
    }
}