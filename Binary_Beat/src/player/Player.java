package player;
import card.Card;
import card.AttackCard;
import card.HealCard;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Player {
    private String name;
    private int hp;
    private List<Card> deck;

    public Player(String name, int hp) {
        this.name = name;
        this.setHp(hp);
        this.deck = new ArrayList<>();
    }

    public void addCardToDeck(Card card) {
        deck.add(card);
    }

    public void drawCard() {
    	Random random = new Random();
    	int randomNum = random.nextInt(2); // 0 or 1
    	
    	if (randomNum == 0) {
    		deck.add(new AttackCard("Lightning Bolt", "Deals 25 damage", 25));
    	} else {
    		deck.add(new HealCard("Magic Healing", "Heals 20 HP", 20));
    	}
    	System.out.println("카드를 뽑았습니다.");
    }
    
    public void playCard(int index, Player opponent) {
        if (index >= 0 && index < deck.size()) {
            Card selectedCard = deck.get(index);
            selectedCard.play(this, opponent);
            deck.remove(index);  // 사용한 카드는 버린다
        }
    }

    public void receiveDamage(int damage) {
        setHp(getHp() - damage);
        if (getHp() < 0) setHp(0);
        System.out.println(name + " HP: " + getHp());
    }
 
    public void heal(int amount) {
        setHp(getHp() + amount);
        if (getHp() > 100) setHp(100);
        System.out.println(name + " HP: " + getHp());
    }

    public boolean isAlive() {
        return getHp() > 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getDeck() {
        return deck;
    }

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
