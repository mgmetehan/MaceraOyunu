
public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Maðaza");
	}

	public boolean getLocation() {
		System.out.println("Paranýz: " + player.getMoney());
		System.out.println("1-Silahlar");
		System.out.println("2-Zýrhlar");
		System.out.println("3-Çýkýþ");
		System.out.print("Seçiminiz: ");
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
		System.out.println("3-Aðýr   Para:40 Hasar:5");
		System.out.println("4-Çýkýþ");
		System.out.print("Silah Seçiniz: ");
		int selArmorId = scan.nextInt();
		return selArmorId;
	}

	public void buyArmor(int itemID) {
		int avoid = 0, price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			avoid = 1;
			aName = "Hafif Zýrh";
			price = 15;
			break;
		case 2:
			avoid = 3;
			aName = "Orta Zýrh";
			price = 15;
			break;
		case 3:
			avoid = 5;
			aName = "Aðýr Zýrh";
			price = 40;
			break;
		case 4:
			System.out.println("Çýkýþ Yapýlýyor.");
			break;
		default:
			System.out.println("Geçersiz Ýþlem !");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInventory().setArmor(avoid);
				player.getInventory().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " satýn aldýnýz, Engellenen Hasar : " + player.getInventory().getArmor());
				System.out.println("Kalan Para :" + player.getMoney());
			} else {
				System.out.println("Para yetersiz. !");
			}
		}
	}

	public int weaponMenu() {
		System.out.println("1-Tabanca Para:25 Hasar:2");
		System.out.println("2-Kýlýç   Para:35 Hasar:3");
		System.out.println("3-Tüfek   Para:45 Hasar:7");
		System.out.println("4-Çýkýþ");
		System.out.print("Silah Seçiniz: ");
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
			wName = "Kýlýç";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Tüfek";
			price = 45;
			break;
		case 4:
			System.out.println("Çýkýþ Yapýlýyor..");
			break;
		default:
			System.out.println("Geçersiz Ýþlem!!");
		}
		if (price > 0) {
			if (player.getMoney() > price) {
				player.getInventory().setDamge(damage);
				player.getInventory().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + " Satýn Aldýnýz.Önceki Hasar: " + player.getDamge() + " Yeni Hasar: "
						+ player.getTotalDamage());
				System.out.println("Kalan Para: " + player.getMoney());
			} else {
				System.out.println("Para yetersiz!!");
			}
		}

	}

}
