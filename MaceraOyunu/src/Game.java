import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Macera Oyununa Hoþgeldiniz\nBu Oyunda Kendine Dikkat Et!!");
		System.out.print("Karakter Ýsminizi Giriniz: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.charMenu();
		System.out.println("\nOyun Baþlýyor.....\n___________________\n");
		start();
	}

	public void start() {
		while (true) {

			System.out.println("\nGitmek Ýstediðiniz Yeri Belirtin: ");
			System.out.println("\n1-Güvenli Ev -> Burda Güvendesin Canýn Yenilenir");
			System.out.println("2-Maðra -> Burda Zombiler Var Dikkat Et");
			System.out.println("3-Orman -> Burda Vampirler Var Dikkat Et");
			System.out.println("4-Nehir -> Burda Ayýlar Var Dikkat Et");
			System.out.println("5-Maðaza -> Burada Silah veya Armor Alabilrsin");
			System.out.print("Nereye Gitmek Ýstersin : ");
			int selectLoc = scan.nextInt();
			while (selectLoc < 1 || selectLoc > 5) {
				System.out.print("Lütfen Geçerli Bir Yer Þeç: ");
				selectLoc = scan.nextInt();
			}
			switch (selectLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}

			if (location.getClass().getName().equals("SafeHouse")) {
				if (player.getInventory().isFirewood() && player.getInventory().isFood()
						&& player.getInventory().isWater()) {
					System.out.println("Tebrikler Oyunu Kazandýnýz !");
					break;
				}
			}
			if (!location.getLocation()) {
				System.out.println("Oyun Bitti !");
				break;
			}

		}
	}
}
