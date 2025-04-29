package card;
import player.Player;

public class AttackCard extends Card{
    private int damage;

    public AttackCard(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    @Override
    public void play(Player user, Player opponent) {
        System.out.println(user.getName() + " uses " + getName() + " to attack for " + damage + " damage!");
        opponent.receiveDamage(damage);
    }
}
