package main;
import player.Player;
import card.AttackCard;
import card.HealCard;
import battle.BattleManager;

public class CardBattleGame {

	public static void main(String[] args) {
        Player player = new Player("You", 100);
        Player enemy = new Player("Enemy", 100);

        // 플레이어 덱 구성
        player.addCardToDeck(new AttackCard("Fireball", "Deals 20 damage", 20));
        player.addCardToDeck(new HealCard("Healing Light", "Heals 15 HP", 15));
        player.addCardToDeck(new AttackCard("Sword Slash", "Deals 15 damage", 15));

        // 적 덱 구성
        enemy.addCardToDeck(new AttackCard("Claw Strike", "Deals 10 damage", 10));
        enemy.addCardToDeck(new AttackCard("Poison Bite", "Deals 15 damage", 15));
        enemy.addCardToDeck(new HealCard("Regenerate", "Heals 10 HP", 10));

        BattleManager battle = new BattleManager(player, enemy);
        battle.startBattle();
	}

}
