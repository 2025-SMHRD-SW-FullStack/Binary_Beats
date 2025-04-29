package card;
import player.Player;

public class HealCard extends Card {
    private int healAmount;

    public HealCard(String name, String description, int healAmount) {
        super(name, description);
        this.healAmount = healAmount;
    }

    @Override
    public void play(Player user, Player opponent) {
        System.out.println(user.getName() + " uses " + getName() + " to heal " + healAmount + " HP!");
        user.heal(healAmount);
    }
}
