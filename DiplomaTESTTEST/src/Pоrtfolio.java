import java.util.Collections;
import java.util.Scanner;

import javax.management.monitor.MonitorSettingException;

public class P�rtfolio {
	private Company stock1;
	private Company stock2;
	private Company stock3;
	private Company stock4;
	private Company stock5;
	private double constValue = 10000;
	private double maneyCash = 0;
	
	
	public P�rtfolio(Company stock1, Company stock2, Company stock3, Company stock4, Company stock5) {
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
		this.stock4 = stock4;
		this.stock5 = stock5;
	}
	
	public void userChoice() {
		
		Collections.reverse(stock1.price);
		Collections.reverse(stock2.price);
		Collections.reverse(stock3.price);
		Collections.reverse(stock4.price);
		Collections.reverse(stock5.price);
		
		Collections.reverse(stock1.profit);
		Collections.reverse(stock2.profit);
		Collections.reverse(stock3.profit);
		Collections.reverse(stock4.profit);
		Collections.reverse(stock5.profit);
		
		for (int i = 0; i < stock1.profit.size(); i++) {
			
			if(stock1.profit.get(i) > 0) {
				Scanner sc = new Scanner(System.in);
				System.out.println("������� ����� �������� " + stock1.getClass().getName() + "?");
				double plus = stock1.profit.get(i);
				System.out.println("��������� ������� �� �������: $" + plus);
				System.out.println("1.�������");
				System.out.println("2.�� ���������");
				int choice = sc.nextInt();
				if (choice == 1) {
					maneyCash += plus;
				}
			}else if(stock1.profit.get(i) < 0) {
				Scanner sc = new Scanner(System.in);
				System.out.println("������ ����� �������� " + stock1.getClass().getName() + "?");
				double minus = (-1) * stock1.profit.get(i);
				System.out.println("��������� ������ �� �������: $" + minus);
				System.out.println("1.������");
				System.out.println("2.�� ��������");
				int choice = sc.nextInt();
				if (choice == 1) {
					maneyCash -= minus;
				}									
			}
			
		}
		System.out.println("Profit: $" + maneyCash);
	}
	
	
	
}
