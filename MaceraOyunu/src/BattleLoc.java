
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("�uan buradas�n�z : " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " ya��yor !");
		System.out.print("<S>ava� veya <K>a� :");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " b�lgesindeki t�m d��manlar� temizlediniz !");
				if (this.award.equals("Food") && player.getInventory().isFood() == false) {
					System.out.println(this.award + " Kazand�n�z! ");
					player.getInventory().setFood(true);
				} else if (this.award.equals("Water") && player.getInventory().isWater() == false) {
					System.out.println(this.award + " Kazand�n�z! ");
					player.getInventory().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInventory().isFirewood() == false) {
					System.out.println(this.award + " Kazand�n�z! ");
					player.getInventory().setFirewood(true);
				}
				return true;
			}

			if (player.getHealty() <= 0) {
				System.out.println("�ld�n�z !");
				return false;
			}

		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealty() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<V>ur veya <K>a� :");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("V")) {
					System.out.println("Siz vurdunuz !");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println();
						System.out.println("Canavar size vurdu !");
						player.setHealty(
								player.getHealty() - (obstacle.getDamage() - player.getInventory().getArmor()));
						afterHit();
					}
				} else {
					return false;
				}
			}

			if (obstacle.getHealth() < player.getHealty()) {
				System.out.println("D��man� yendiniz !");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("G�ncel Paran�z : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("-------------------");
		}
		return true;
	}

	public void playerStats() {
		System.out.println("Oyuncu De�erleri\n--------------");
		System.out.println("Can:" + player.getHealty());
		System.out.println("Hasar:" + player.getTotalDamage());
		System.out.println("Para:" + player.getMoney());
		if (player.getInventory().getDamge() > 0) {
			System.out.println("Silah:" + player.getInventory().getwName());
		}
		if (player.getInventory().getArmor() > 0) {
			System.out.println("Z�rh:" + player.getInventory().getaName());
		}
	}

	public void enemyStats() {
		System.out.println("\n" + obstacle.getName() + " De�erleri\n--------------");
		System.out.println("Can:" + obstacle.getHealth());
		System.out.println("Hasar:" + obstacle.getDamage());
		System.out.println("�d�l:" + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Oyuncu Can�:" + player.getHealty());
		System.out.println(obstacle.getName() + " Can�:" + obstacle.getHealth());
		System.out.println();
	}

}
