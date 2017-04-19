import java.util.LinkedList;

public class ExersciseList {
	
	public static LinkedList interleave (LinkedList list1, LinkedList list2) {
		LinkedList<String> list = new LinkedList<>();
		for(int i = 0; i < list1.size(); i++) {
			list.add((String) list1.get(i));//add to new list element from list 1
			if(list2.size() > i){//if size list 2 greater than i add element from list 2
			list.add((String) list2.get(i));
			}	
		}
		return list;
	}
	
	public static void swap(LinkedList<String> list,int start, String str1, int end, String str2) {
		String str3 = new String(str1);//string for swap
		str1 = new String(str2);
		str2 = new String(str3);
		list.set(start, str1);//set to start position str1
		list.set(end, str2);//set to end position str2
	}
	
	public static void reverse (LinkedList<String> list) {
		for(int i = 0; i < list.size()/2; i++) {
			swap(list, i, (String)list.get(i),list.size()-1-i, (String)list.get(list.size()-1-i));//call swap
		}
	}
	
	public static void chopSkip(LinkedList list) {
		for(int i = 0; i < list.size(); i++) {
			if(i == 1 || i == 2 || i == 3) {
				list.remove(i);
			}
		}
	}

	public static void main(String[] args) {
		
		LinkedList<String> list1 = new LinkedList<>();
		LinkedList<String> list2 = new LinkedList<>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		list1.add("E");
		list1.add("F");
		
		list2.add("W");
		list2.add("X");
		list2.add("Y");
		list2.add("Z");
		
		System.out.println("List 1:" + list1.toString());
		System.out.println("List 2:" + list2.toString());
		
		LinkedList<String> listInterleave = interleave(list1, list2);
		System.out.println("List interleave: "+listInterleave.toString());
		reverse(list1);
		System.out.println("Reverse list 1:" + list1);
		
		LinkedList<String> list3 = new LinkedList<>();
		list3.add("aardvark");
		list3.add("bear");
		list3.add("cougar");
		list3.add("dog");
		list3.add("elephant");
		list3.add("fox");
		System.out.println("List: " + list3.toString());
		chopSkip(list3);
		System.out.println("List: " + list3.toString());
	}

}
