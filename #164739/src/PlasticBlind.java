
/**
 * Write a description of class PlasticBlind here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasticBlind extends SlattedBlind {
    public PlasticBlind() {
        rValue = 1.9;
        slatDepth = 3;
    }
    public void setPriceForArea(int width, int height) {
        final int PRICING_HEADER = 20;
        final int PRICING_MATERIAL = 9;
        int area = width + height;
        int perimeter = (width + height) * 2;
        this.price = PRICING_HEADER * perimeter + PRICING_MATERIAL * area;
    }
   
}
