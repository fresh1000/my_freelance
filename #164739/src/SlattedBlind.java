
/**
 * Abstract class SlattedBlind - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class SlattedBlind {
    protected int slatDepth;
    protected int price;
    protected double rValue;
    public abstract void setPriceForArea(int width, int height);
    
    public SlattedBlind() {
        slatDepth = 0;
        price = 0;
        rValue = 0.0;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public double getRvalue() {
        return rValue;
    }
    
    public String toString(){
        return "SlatDepth = " + slatDepth + ", R-value = " + rValue + ", Price = " + price;
    }
}
