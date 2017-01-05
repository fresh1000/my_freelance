import javax.swing.JFrame;

class CalculatorDemo{
    public static void main(String[] args) {
        JFrame calcFrame = new JFrame("Калькулятор");
        Calc calc = new Calc();
        calcFrame.add(calc);
        calcFrame.setSize(400, 300);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(true);
    }
}