// FullName: Panagiotis Ntovonis | AM: 5314

import java.util.Scanner;

class Player {

    private String name;
    private Hand playerHand = new Hand();

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    // Public Method | draw
    public void draw(Table table) {
        Card cardToAdd = table.drawCard();
        playerHand.addCard(cardToAdd);
    }

    // Public Method | draw (overloaded)
    public void draw(Table table,int amount) {
        for (int i = 0; i < amount; i++) {
            Card cardToAdd = table.drawCard();
            playerHand.addCard(cardToAdd);
        }
    }

    // Public Method | throwCard
    public void throwCard(Table table,Card card) {
        table.throwCard(card);
        playerHand.removeCard(card);
    }

    // Public Method | isDone
    public boolean isDone() {
        return playerHand.isEmpty();
    }

    // Public Method | toString
    public String toString() {
        return this.name;
    }

    // Public Method | selectCard
    public Card selectCard(Table table) {
        Scanner input = new Scanner(System.in);
        while (true) {
            playerHand.printHand();
            System.out.println("\nSelect a card to throw or -1 to pass:");
            int choice = input.nextInt();
            if (choice == -1) {
                return null;
            }
            else if (playerHand.getCard(choice).getNumber() == 8) {
                System.out.println("Select the color:");
                String newColor = input.next();
                playerHand.getCard(choice).setSuit(newColor.toUpperCase());
                return playerHand.getCard(choice);
            }
            else {
                if (playerHand.getCard(choice).matches(table.getTopCard())) {
                    return playerHand.getCard(choice);
                }
            }
        }
    }

    // Public Method | computerSelectCard
    public Card computerSelectCard(Table table) {
        // If you want to print Computer's Hand too
        // playerHand.printHand();
        return playerHand.findMatchingCard(table.getTopCard());
    }

    // Extra Method | isComputer
    public boolean isComputer() {
        String[] strArray = (this.name).split(" ");
        return strArray[0].equals("Computer");
    }

    // Main Method
    public static void main(String[] args) {
        Player ntov = new Player("Ntov");
        Table table = new Table();
        Card card = new Card(1,"D");
        ntov.draw(table,5);
        ntov.throwCard(table,card);
        System.out.println(ntov.isDone());
        System.out.println(ntov.isComputer());
    }

}