
public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}

	public boolean getLocation() {
		player.setHealty(player.getrHealty());
		System.out.println("Þu an Güvenli Ev adlý yerdesiniz.\nCanýnýz Doldu..");
		return true;
	}
}
