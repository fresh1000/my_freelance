package src.lab4.test;

import src.lab4.store.ProductStore;
import src.lab4.store.WoodDirectory;
import src.lab5.model.Cilinder;
import src.lab5.model.IWeight;
import src.lab5.model.Timber;
import src.lab5.model.Waste;
import src.lab5.model.Wood;

import java.io.IOException;
import java.util.Scanner;


public class TestByConsole {

		private WoodDirectory wd = new WoodDirectory();
		private ProductStore ps = new ProductStore();
		private Scanner sc = new Scanner(System.in);
		
		int nextInt = 0;

		public static void main(String[] args) {
			TestByConsole tbc = new TestByConsole();
			tbc.startApp();
		}

		private void startApp() {
			this.showMenu();
		}

		public void showMenu() {
			StringBuilder sb = new StringBuilder("Меню:\n");
			sb.append("1. Додати деревину\n2. Додати брус\n3.Додати мішок \n4. Додати циліндр\n5.Підрахувати загальну вагу\n6. Вивести все\n7. Вихід");
			System.out.println(sb);
			
			this.nextInt = sc.nextInt();
			
			
			this.run(this.nextInt);
		}

		private void run(int nextInt) {
			switch (nextInt) {
			case 1:
				this.addWood();
				break;
			case 2:
				this.addTimber();
				break;
			case 3:
				this.addWaste();
				break;
			case 4:
				this.addCilinder();
				break;
			case 5:
				this.calcWeight();
				break;
			case 6:
				this.showAll();
				break;
			case 7:
				sc.close();
				System.exit(0);
			
			}
		}

		private void showAll() {
			System.out.println(wd);
			System.out.println(ps);
			this.showMenu();
		}

		private float calcWeight() {
			float fullWeight = 0;
			for (Object timber: ps.getArr()){
				fullWeight+=((IWeight)timber).weight();
			}
			
			System.out.println(ps);
			return fullWeight;

			
		}

		private void addCilinder() {
			int i=0;
			System.out.println("Додаємо циліндр: Введіть дані за наступним прикладном"
					+ "\n id дерева/довжина/діаметр\n");
			Scanner scan = new Scanner(System.in);
			scan.useDelimiter("/");
			Cilinder flashback=null;
			try {
				flashback = new Cilinder(wd.get(sc.nextInt()), sc.nextFloat(), sc.nextFloat());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			System.out.println(e.getMessage());
			addCilinder();
		}
	if (flashback!=null)
			ps.add(flashback);
			this.showMenu();

		}

		private void addWaste() {
			float i=0;
			System.out.println("Вкажіть вагу мішка\n");
			Scanner scan = new Scanner(System.in);
			scan.useDelimiter("/");
			Waste flashback = null;
			
			try {
				flashback = new Waste(sc.nextFloat());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
				addWaste();
			}
	if (flashback!=null)
		ps.add(flashback);
		this.showMenu();

		}

		
		private void addTimber() {
			System.out.println("Запишіть: idБрусу , Довжину бруса ,Висоту бруса , Ширину бруса");
			try {
				Timber tmbr = new Timber(wd.get(sc.nextInt()), sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Timber flashback = null;
			try {
				flashback = new Timber(wd.get(sc.nextInt()), sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				addTimber();
			}
		if (flashback!=null)
				ps.add(flashback);
				this.showMenu();
				

		}

		private void addWood() {
			System.out.println("Запишіть: idДеревини, Назву, Щільність");
			int a = sc.nextInt();
			String b = sc.next();
			float c = sc.nextFloat();
			Wood wood = new Wood(a, b, c);
			wd.add(wood);
			this.showMenu();
		}

	}


