package card;
import player.Player;

public abstract class Card {
    private String name;
    private String description;

    public Card(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public abstract void play(Player user, Player opponent);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
