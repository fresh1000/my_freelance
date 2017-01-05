
public class Tester {

	public static void main(String[] args) {
		
		List ml = new List();
        ml.addBack(1);
        ml.addBack(2);
        ml.addBack(3);
        ml.addFront(6);
        ml.addFront(31);
        
        ml.printList();
        System.out.println();
        
        ml.delEl(6);
        ml.delEl(5);
        ml.delEl(12);
        ml.delEl(2);
 
        ml.printList();
        System.out.println();
        
        Queue myQ = new Queue(10);
        
        myQ.insert(52);
        myQ.insert(51);
        myQ.insert(125);
        myQ.insert(23215);
        myQ.insert(23135);
        myQ.insert(34345);
        myQ.insert(325);
        myQ.insert(125);
        
        while (!myQ.isEmpty()) {
        	int n = myQ.remove();
        	System.out.println(n);
        	
        }

	}

}
