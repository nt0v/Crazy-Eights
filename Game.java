// FullName: Panagiotis Ntovonis | AM: 5314

import java.util.Scanner;

class Game {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give the number of players:");
        int numberOfPlayers = input.nextInt();
        CrazyEights game = new CrazyEights(numberOfPlayers);
        game.play();
    }

}