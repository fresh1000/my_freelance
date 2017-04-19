
/**
 * Write a description of class WoodBlind here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WoodBlind extends SlattedBlind {
    
    public WoodBlind() {
        rValue = 1.7;
        slatDepth = 2;
    }
    
    public void setPriceForArea(int width, int height) {
        final int PRICING_HEADER = 20;
        final int PRICING_MATERIAL = 15;
        int area = width + height;
        int perimeter = (width + height) * 2;
        this.price = PRICING_HEADER * perimeter + PRICING_MATERIAL * area;
    }

}


