import java.awt.Color;

/**
 * TestHeadPhone
 * Class TestHeadPhone test a HeadPhone class.
 *
 * Date:
 * @author (your name)
 */
public class TestHeadPhone {

	public static void main(String[] args) {

		HeadPhone headPhone1 = new HeadPhone();
		HeadPhone headPhone2 = new HeadPhone();
		HeadPhone headPhone3 = new HeadPhone();
		
		headPhone1.setHeadPhoneColor(Color.BLUE);//test setHeadPhoneColor
		headPhone1.setPluggedIn(true);//test setPluggedIn
		headPhone1.changeVolume(3);//test  changeVolume
		headPhone1.setHeadPhoneModel("LD-213");//test setHeadPhoneModel
		headPhone1.setManufacturer("LG");// test setManufacturer
		System.out.println("Color: " + headPhone1.getHeadPhoneColor());//test getHeadPhoneColor
		System.out.println("PluggedIn: " + headPhone1.isPluggedIn());//test isPluggedIn
		System.out.println("Volume: " + headPhone1.getVolume());//test getVolume
		System.out.println("Headphone model: " + headPhone1.getHeadPhoneModel());//test getHeadPhoneModel
		System.out.println("Manufacturer: " + headPhone1.getManufacturer());//test getManufacturer
		System.out.println(headPhone1.toString());//test toString
		System.out.println();
		
		headPhone2.setHeadPhoneColor(Color.BLACK);//test setHeadPhoneColor
		headPhone2.setPluggedIn(false);//test setPluggedIn
		headPhone2.changeVolume(1);//test  changeVolume
		headPhone2.setHeadPhoneModel("SD-2");//test setHeadPhoneModel
		headPhone2.setManufacturer("Apple");// test setManufacturer
		System.out.println("Color: " + headPhone2.getHeadPhoneColor());//test getHeadPhoneColor
		System.out.println("PluggedIn: " + headPhone2.isPluggedIn());//test isPluggedIn
		System.out.println("Volume: " + headPhone2.getVolume());//test getVolume
		System.out.println("Headphone model: " + headPhone2.getHeadPhoneModel());//test getHeadPhoneModel
		System.out.println("Manufacturer: " + headPhone2.getManufacturer());//test getManufacturer
		System.out.println(headPhone2.toString());//test toString
		System.out.println();
		
		headPhone3.setHeadPhoneColor(Color.GREEN);//test setHeadPhoneColor
		headPhone3.setPluggedIn(true);//test setPluggedIn
		headPhone3.setVolume(5);//test  setVolume
		headPhone3.setHeadPhoneModel("A-298");//test setHeadPhoneModel
		headPhone3.setManufacturer("Lenovo");// test setManufacturer
		System.out.println("Color: " + headPhone3.getHeadPhoneColor());//test getHeadPhoneColor
		System.out.println("PluggedIn: " + headPhone3.isPluggedIn());//test isPluggedIn
		System.out.println("Volume: " + headPhone3.getVolume());//test getVolume
		System.out.println("Headphone model: " + headPhone3.getHeadPhoneModel());//test getHeadPhoneModel
		System.out.println("Manufacturer: " + headPhone3.getManufacturer());//test getManufacturer
		System.out.println(headPhone3.toString());//test toString
		System.out.println();
		

	}

}
