package card;
import player.Player;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleManager {
    private Player player;
    private Player enemy;
    private Scanner scanner = new Scanner(System.in);

    public BattleManager(Player player, Player enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startBattle() {
        System.out.println("=== Card Battle Start! ===");

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nYour HP: " + player.getHp() + " | Enemy HP: " + enemy.getHp());
            System.out.println("Your turn! Choose a card to play:");

            List<Card> deck = player.getDeck();
            for (int i = 0; i < deck.size(); i++) {
                System.out.println("(" + i + ") " + deck.get(i).getName() + " - " + deck.get(i).getDescription());
            }

            int choice = scanner.nextInt();
            player.playCard(choice, enemy);

            if (!enemy.isAlive()) break;

            // Enemy Turn
            System.out.println("\nEnemy's turn!");
            List<Card> enemyDeck = enemy.getDeck();
            int enemyChoice = new Random().nextInt(enemyDeck.size());
            enemy.playCard(enemyChoice, player);
            
            //턴이 끝날 때 둘 다 카드 드로우
            player.drawCard();
            enemy.drawCard();
        }

        if (player.isAlive()) {
            System.out.println("\n=== You Win! ===");
        } else {
            System.out.println("\n=== You Lose... ===");
        }
    }
}
