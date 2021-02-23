import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Macera Oyununa Ho�geldiniz\nBu Oyunda Kendine Dikkat Et!!");
		System.out.print("Karakter �sminizi Giriniz: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.charMenu();
		System.out.println("\nOyun Ba�l�yor.....\n___________________\n");
		start();
	}

	public void start() {
		while (true) {

			System.out.println("\nGitmek �stedi�iniz Yeri Belirtin: ");
			System.out.println("\n1-G�venli Ev -> Burda G�vendesin Can�n Yenilenir");
			System.out.println("2-Ma�ra -> Burda Zombiler Var Dikkat Et");
			System.out.println("3-Orman -> Burda Vampirler Var Dikkat Et");
			System.out.println("4-Nehir -> Burda Ay�lar Var Dikkat Et");
			System.out.println("5-Ma�aza -> Burada Silah veya Armor Alabilrsin");
			System.out.print("Nereye Gitmek �stersin : ");
			int selectLoc = scan.nextInt();
			while (selectLoc < 1 || selectLoc > 5) {
				System.out.print("L�tfen Ge�erli Bir Yer �e�: ");
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
					System.out.println("Tebrikler Oyunu Kazand�n�z !");
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
