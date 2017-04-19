import java.util.Scanner;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width, height, priceAll = 0;
        System.out.print("Enter width: ");
        width = sc.nextInt();
        System.out.print("Enter height: ");
        height = sc.nextInt();
        int choiceSlatter;
        System.out.println("Choice slatter blind:");
        System.out.println("1.Wood blind(R-value:1.7)");
        System.out.println("2.Plastic blind(R-value:1.9)");
        System.out.print("Your choice:");
        choiceSlatter = sc.nextInt();
        if(choiceSlatter == 1) {
           WoodBlind w = new WoodBlind();
           w.setPriceForArea(width, height);
           priceAll += w.getPrice();
           System.out.println("Price slatter: $" + w.getPrice());
        }
        if(choiceSlatter == 2) {
           PlasticBlind p = new PlasticBlind();
           p.setPriceForArea(width, height);
           priceAll += p.getPrice();
           System.out.println("Price slatter: $" + p.getPrice());
        }
        System.out.println("All price: $" + priceAll);
        System.out.println();
        
        int choiceCell;
        System.out.println("Choice honeycomb shade:");
        System.out.println("1.Single cell(R-value:2.3)");
        System.out.println("2.Double cell(R-value:2.8)");
        System.out.println("3.Blackout(R-value:4)");
        System.out.print("Your choice:");
        choiceCell = sc.nextInt();
        if(choiceCell == 1) {
           SingleCell s = new SingleCell();
           s.setPriceForArea(width, height);
           priceAll += s.getPrice();
           System.out.println("Price honeycomb shade: $" + s.getPrice());
        }
        if(choiceCell == 2) {
           DoubleCell d = new DoubleCell();
           d.setPriceForArea(width, height);
           priceAll += d.getPrice();
           System.out.println("Price honeycomb shade: $" + d.getPrice());
        }
        if(choiceCell == 3) {
           Blackout b = new Blackout();
           b.setPriceForArea(width, height);
           priceAll += b.getPrice();
           System.out.println("Price honeycomb shade: $" + b.getPrice());
        }
        System.out.println("All price: $" + priceAll);
        System.out.println();
        
        int choiceCurtains;
        System.out.println("Choice curtains:");
        System.out.println("1.Light lining(R-value:1.6)");
        System.out.println("2.Normal(R-value:1.9)");
        System.out.println("3.Heavy(R-value:2.2)");
        System.out.print("Your choice:");
        choiceCurtains = sc.nextInt();
        if(choiceCurtains == 1) {
           LightLining l = new LightLining();
           l.setPriceForArea(width, height);
           priceAll += l.getPrice();
           System.out.println("Price curtains: $" + l.getPrice());
        }
        if(choiceCurtains == 2) {
           Normal n = new Normal();
           n.setPriceForArea(width, height);
           priceAll += n.getPrice();
           System.out.println("Price curtains: $" + n.getPrice());
        }
        if(choiceCurtains == 3) {
           Heavy h = new Heavy();
           h.setPriceForArea(width, height);
           priceAll += h.getPrice();
           System.out.println("Price curtains: $" + h.getPrice());
        }
        System.out.println("All price: $" + priceAll);
        System.out.println();
    }
}
