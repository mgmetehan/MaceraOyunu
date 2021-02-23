
public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Ma�aza");
	}

	public boolean getLocation() {
		System.out.println("Paran�z: " + player.getMoney());
		System.out.println("1-Silahlar");
		System.out.println("2-Z�rhlar");
		System.out.println("3-��k��");
		System.out.print("Se�iminiz: ");
		int selTool = scan.nextInt();
		int selltemId;
		switch (selTool) {
		case 1:
			selltemId = weaponMenu();
			buyWeapon(selltemId);
			break;
		case 2:
			selltemId = armorMenu();
			buyArmor(selltemId);
			break;
		default:
			break;
		}
		return true;
	}

	public int armorMenu() {
		System.out.println("1-Hafif  Para:15 Hasar:2");
		System.out.println("2-Orta   Para:25 Hasar:3");
		System.out.println("3-A��r   Para:40 Hasar:5");
		System.out.println("4-��k��");
		System.out.print("Silah Se�iniz: ");
		int selArmorId = scan.nextInt();
		return selArmorId;
	}

	public void buyArmor(int itemID) {
		int avoid = 0, price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			avoid = 1;
			aName = "Hafif Z�rh";
			price = 15;
			break;
		case 2:
			avoid = 3;
			aName = "Orta Z�rh";
			price = 15;
			break;
		case 3:
			avoid = 5;
			aName = "A��r Z�rh";
			price = 40;
			break;
		case 4:
			System.out.println("��k�� Yap�l�yor.");
			break;
		default:
			System.out.println("Ge�ersiz ��lem !");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInventory().setArmor(avoid);
				player.getInventory().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " sat�n ald�n�z, Engellenen Hasar : " + player.getInventory().getArmor());
				System.out.println("Kalan Para :" + player.getMoney());
			} else {
				System.out.println("Para yetersiz. !");
			}
		}
	}

	public int weaponMenu() {
		System.out.println("1-Tabanca Para:25 Hasar:2");
		System.out.println("2-K�l��   Para:35 Hasar:3");
		System.out.println("3-T�fek   Para:45 Hasar:7");
		System.out.println("4-��k��");
		System.out.print("Silah Se�iniz: ");
		int selWeaponId = scan.nextInt();
		return selWeaponId;
	}

	public void buyWeapon(int itemId) {
		int damage = 0, price = 0;
		String wName = null;
		switch (itemId) {
		case 1:
			damage = 2;
			wName = "Tabanca";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "K�l��";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "T�fek";
			price = 45;
			break;
		case 4:
			System.out.println("��k�� Yap�l�yor..");
			break;
		default:
			System.out.println("Ge�ersiz ��lem!!");
		}
		if (price > 0) {
			if (player.getMoney() > price) {
				player.getInventory().setDamge(damage);
				player.getInventory().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + " Sat�n Ald�n�z.�nceki Hasar: " + player.getDamge() + " Yeni Hasar: "
						+ player.getTotalDamage());
				System.out.println("Kalan Para: " + player.getMoney());
			} else {
				System.out.println("Para yetersiz!!");
			}
		}

	}

}
