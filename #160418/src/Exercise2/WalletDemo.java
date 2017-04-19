package Exercise2;

public class WalletDemo {

	public static void main(String[] args) {
		Wallet wallet = new Wallet(8);//wallet capacity 8
		Coin coin1 = new Coin("Toonie");
		Coin coin2 = new Coin("Toonie");
		Coin coin3 = new Coin("Loonie");
		Coin coin4 = new Coin("Quarter");
		Coin coin5 = new Coin("Quarter");
		Coin coin6 = new Coin("Dime");
		Coin coin7 = new Coin("Nickel");
		wallet.addCoin(coin1);//add 200
		wallet.addCoin(coin2);//add 200
		wallet.addCoin(coin5);//add 25
		wallet.removeCoin();//delete 25
		System.out.println(wallet.toString());
	}

}
