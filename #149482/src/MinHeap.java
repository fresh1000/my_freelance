import java.util.*;

@SuppressWarnings("unchecked")
public class MinHeap<AnyType extends Comparable<AnyType>> {
   private int sizeArr;            
   private AnyType[] MinHeap;
   private static final int CONTENT = 2;
   
   public MinHeap(AnyType[] array) {
      sizeArr = array.length;
      MinHeap = (AnyType[]) new Comparable[array.length+1];

      System.arraycopy(array, 0, MinHeap, 1, array.length);

      buildHeap();
   }

   private void buildHeap() {
      for (int r = sizeArr/2; r > 0; r--)
      {
         percDown(r);
      }
   }
   
   public MinHeap() {
      sizeArr = 0;
      MinHeap = (AnyType[]) new Comparable[CONTENT];
   }
   
   private void percDown(int m) {
      AnyType temp = MinHeap[m];
      int children;
      for(; 2*m <= sizeArr; m = children)
      {
         children = 2*m;
         if(children != sizeArr &&
            MinHeap[children].compareTo(MinHeap[children + 1]) > 0) {
        	 children++;
         }
         if(temp.compareTo(MinHeap[children]) > 0) { 
        	 MinHeap[m] = MinHeap[children];
         }
         else
        	 break;
      }
      MinHeap[m] = temp;
   }

   public AnyType deleteMin() throws RuntimeException {
      if (sizeArr == 0) throw new RuntimeException();
      AnyType min = MinHeap[1];
      MinHeap[1] = MinHeap[sizeArr--];
      percDown(1);
      return min;
	}

   public void insert(AnyType x) {
      if(sizeArr == MinHeap.length - 1) DoubleSize();
      int position = ++sizeArr;
      for(; position > 1 && x.compareTo(MinHeap[position/2]) < 0; position = position/2 ){
         MinHeap[position] = MinHeap[position/2];
      }
      MinHeap[position] = x;
   }
   

   public String toString() {
      String toString = "";
      for(int l = 1; l <= sizeArr; l++) {
    	  toString += MinHeap[l]+" ";
      }
      return toString;
   }

   private void DoubleSize() {
	   AnyType [] old = MinHeap;
	   MinHeap = (AnyType []) new Comparable[MinHeap.length * 2];
	   System.arraycopy(old, 1, MinHeap, 1, sizeArr);
   	}
   
   public static void add(ArrayList<Event> list) {
	   list.add(readEvent());
	}
	
   private void insert() {
	   insert((AnyType) readEvent());
   }
	
   private static Event readEvent() {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Event Type:");
	   String name = sc.nextLine();
	   Event event = null;
	   if(name.equals(Arrival.class.getName())) {
		   event = new Arrival();
	   }
	   
	   if(name.equals(Termination.class.getName())) {
		   event = new Termination();
	   }
		
	   if(name.equals(EndOfService.class.getName())) {
		   event = new EndOfService();
	   }
	   System.out.println("Time:");
	   double time = sc.nextDouble();
	   event.timeOfEvent = time;
	   System.out.println("Done.");
	   return event;
	}
	
   public static void printArray(ArrayList<Event> arrA) {
	   for (Event event : arrA) {
		   if (event != null) {
			   System.out.print(event);
		   }
	   }
	   System.out.println();
   }
	
   private void print() {
	   System.out.println(toString());
   }
	
   public static void main(String args[]){
	   ArrayList<Event> ls = new ArrayList<Event>();
		
	   Event[] arr = {};
		
	   boolean builtHeap = false;
	   MinHeap<Event> minHeap = null;
		
	   Scanner sc = new Scanner(System.in);
	   int choice = 0;
	   while(choice != 6) {
			
	   System.out.println("1. Add Event");	
	   System.out.println("2. Insert");
	   System.out.println("3. Print Array");
	   System.out.println("4. Build Heap");
	   System.out.println("5. Delete Min");
	   System.out.println("6. Quit");
			
	   choice = sc.nextInt();
			
	   switch (choice) {
		case 1:
			System.out.println("Option: 1");
			add(ls);
			break;
		case 2:
			System.out.println("Option: 2");
			if (builtHeap) {
				minHeap.insert();
			}else
			System.out.println("Can’t insert into the heap use build heap first or just add");
			break;
		case 3:
			System.out.println("Option: 3");
			if (builtHeap) {
				minHeap.print();
			}else
			printArray(ls);
			break;
		case 4:
			System.out.println("Option: 4");
			arr = ls.toArray(arr);
			minHeap = new MinHeap<Event>(arr);
			minHeap.buildHeap();
			builtHeap = true;
			break;
		case 5:
			System.out.println("Option: 5");
			minHeap.deleteMin();
			break;
		default:
			break;
			   }
	   }
		System.out.println("Thank You.");
	}	
}
