
public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "G�venli Ev");
	}

	public boolean getLocation() {
		player.setHealty(player.getrHealty());
		System.out.println("�u an G�venli Ev adl� yerdesiniz.\nCan�n�z Doldu..");
		return true;
	}
}
