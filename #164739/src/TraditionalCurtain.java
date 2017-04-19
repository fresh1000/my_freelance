
/**
 * Abstract class TraditionalCurtain - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class TraditionalCurtain{
    protected double rValue;
    protected int price;
    public abstract void setPriceForArea(int width, int height);
    
    public int getPrice() {
        return this.price;
    }
    
    public double getRvalue() {
        return rValue;
    }
    
    public String toString(){
        return "R-value = " + rValue + ", Price = " + price;
    }
}
