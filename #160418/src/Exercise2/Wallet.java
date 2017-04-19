package Exercise2;

import java.util.Arrays;

public class Wallet {
	private Coin[] arrCoin;
	private int capacity;
	private int num;
	private int totalValue;

	public Wallet(int capacity) {
		this.capacity = capacity;
		num = 0;
		totalValue = 0;
		arrCoin = new Coin[capacity];
	}

	public void addCoin(Coin coin) {
		if (num >= capacity) {//if capacity wallet less or equals, don't add
			System.out.println("Error, full wallet!!");
		} else {
			arrCoin[num] = coin;// add coin to array wallet
			num++;//num + 1
			totalValue = totalValue + coin.getValue();//totalValue plus value coin
		}
	}

	public void removeCoin() {
		if (num == 0) {//if wallet have 0 coin
			System.out.println("Error, don't have money");
		} else {
			totalValue = totalValue - arrCoin[num-1].getValue();//remove value deleted coin
			arrCoin = Arrays.copyOf(arrCoin, num-1);//copy array (with length - 1)
			num--;//num - 1
		}
	}

	public String toString() {
		return "Wallet [arrCoin=" + Arrays.toString(arrCoin) + ", capacity=" + capacity + ", num=" + num
				+ ", totalValue=" + totalValue + "]";
	}

}
