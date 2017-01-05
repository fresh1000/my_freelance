
public class List {
	private ListElement head;// указатель на первый элемент
	private ListElement tail;// указатель последний элемент
	
	//добавить спереди
	public void addFront(int data) {
		ListElement a = new ListElement();//создаём новый элемент
		a.data = data;//инициализируем данные
		
		if (head == null) {
			head = a;
			tail = a;
		}else {
			a.next = head;
			head = a;
		}
	}
	
	public void addBack(int data) {
		ListElement a = new ListElement();
		a.data = data;
		
		if (tail == null) {
			head = a;
			tail = a;
		}else {
			tail.next = a;
			tail = a;
		}
	}
	
	public void printList() {
		ListElement t = head;       //получаем ссылку на первый элемент   
        while (t != null)           //пока элемент существуе
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next;                     //и переключаемся на следующий
        }
	}
	
	public void delEl(int data) {
        if(head == null)        //если список пуст - 
            return;             //ничего не делаем
 
        if (head == tail) {     //если список состоит из одного элемента
            head = null;        //очищаем указатели начала и конца
            tail = null;
            return;             //и выходим
        }
 
        if (head.data == data) {    //если первый элемент - тот, что нам нужен
            head = head.next;       //переключаем указатель начала на второй элемент
            return;                 //и выходим
        }
 
        ListElement t = head;       //иначе начинаем искать
        while (t.next != null) {    //пока следующий элемент существует
            if (t.next.data == data) {  //проверяем следующий элемент
                if(tail == t.next)      //если он последний
                {
                    tail = t;           //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next.next;   //найденный элемент выкидываем
                return;                 //и выходим
            }
            t = t.next;                //иначе ищем дальше
        }
    }
	
}
