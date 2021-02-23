import java.util.Scanner;

public class Player {
	private int damge, healty, money, rHealty;
	private String charName, name;
	private Inventory inventory;
	Scanner scan = new Scanner(System.in);

	public void charMenu() {
		System.out.println("\nSava���n�z� �e�iniz");
		System.out.println("1-Samuray  Hasar->5  Sa�l�k->21  Money->15");
		System.out.println("2-Ok�u     Hasar->7  Sa�l�k->18  Money->20");
		System.out.println("3-��valye  Hasar->8  Sa�l�k->24  Money->5");
		System.out.print("Se�iminiz: ");
		int charId = scan.nextInt();
		while (charId < 1 || charId > 3) {
			System.out.print("L�tfen Ge�erli Bir Karakter �e�iniz ");
			charId = scan.nextInt();
		}
		selectCharMenu(charId);
	}

	public void selectCharMenu(int secim) {
		switch (secim) {
		case 1:
			initPlayer("Samuray", 5, 21, 15);
			break;
		case 2:
			initPlayer("Ok�u", 7, 18, 20);
			break;
		case 3:
			initPlayer("��valye", 8, 25, 5);
			break;
		default:
			initPlayer("��valye", 8, 25, 5);
			break;
		}
		System.out.println("Karakter Olu�turuluyor...\nAd�: " + getCharName() + "   Hasar�: " + getDamge()
				+ "   Sa�l�k: " + getHealty() + "   Paras�: " + getMoney());
	}

	public void initPlayer(String cname, int dmg, int hlty, int mny) {
		setCharName(cname);
		setDamge(dmg);
		setHealty(hlty);
		setMoney(mny);
		setrHealty(hlty);
	}

	public int getTotalDamage() {
		return this.getDamge() + this.getInventory().getDamge();
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}

	public int getrHealty() {
		return rHealty;
	}

	public void setrHealty(int rHealty) {
		this.rHealty = rHealty;
	}

	public int getHealty() {
		return healty;
	}

	public void setHealty(int healty) {
		this.healty = healty;
	}

	public int getDamge() {
		return damge;
	}

	public void setDamge(int damge) {
		this.damge = damge;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
