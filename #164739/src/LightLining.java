
/**
 * Write a description of class Light here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightLining extends TraditionalCurtain{
    public LightLining() {
        rValue = 1.6;
    }
    
    public void setPriceForArea(int width, int height) {
        final int PRICING_RODS = 7;
        final int PRICING_MATERIAL = 7;
        int area = width + height;
        int perimeter = (width + height) * 2;
        this.price = PRICING_RODS * perimeter + PRICING_MATERIAL * area;
    }
}
