// FullName: Panagiotis Ntovonis | AM: 5314

import java.util.Scanner;

class CrazyEights {

    private Table table = new Table();
    private Player[] players;
    private int numberOfPlayers;
    private String humanName;

    // Constructor
    public CrazyEights(int numberOfPlayers) {
        Scanner input = new Scanner(System.in);
        this.numberOfPlayers = numberOfPlayers;
        players = new Player[numberOfPlayers];
        System.out.println("Type your name or -1 to play as 'Human'");
        humanName = input.next();
        if (humanName.equals("-1")) {
            humanName = "Human";
        }
        Player human = new Player(humanName);
        players[0] = human;
        for (int i = 0; i < (numberOfPlayers-1); i++) {
            Player computer = new Player("Computer " + (i+1));
            players[i+1] = computer;
        }
    }

    // Public Method | play
    public void play() {
        boolean gameIsOver = false;
        for (int i = 0; i < players.length; i++) {
            players[i].draw(table,5);
        }
        while (!gameIsOver) {
            for (int i = 0; i < players.length; i++) {
                if (players[i].isComputer()) {
                    System.out.println(players[i] + " turn:");
                    System.out.println("Table top card: " + table.getTopCard());
                    Card selectedCard = players[i].computerSelectCard(table);
                    if (selectedCard != null) {
                        System.out.println("\n" + players[i] + " threw card " + selectedCard + "\n");
                        players[i].throwCard(table,selectedCard);
                    }
                    else {
                        System.out.println("\n" + players[i] + " drew a card\n");
                        players[i].draw(table);
                    }
                    if (players[i].isDone()) {
                        System.out.println(players[i] + " won the game!");
                        gameIsOver = true;
                        break;
                    }
                }
                else {
                    System.out.println(players[i] + " turn:");
                    System.out.println("Table top card: " + table.getTopCard());
                    Card selectedCard = players[i].selectCard(table);
                    if (selectedCard != null) {
                        System.out.println(players[i] + " threw card " + selectedCard + "\n");
                        players[i].throwCard(table,selectedCard);
                    }
                    else {
                        System.out.println(players[i] + " drew a card\n");
                        players[i].draw(table);
                    }
                    if (players[i].isDone()) {
                        System.out.println(players[i] + " won the game!");
                        gameIsOver = true;
                        break;
                    }
                }
            }
        }
    }

}