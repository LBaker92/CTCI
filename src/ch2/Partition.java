package ch2;

public class Partition {

	public static void main(String[] args) {
		CTCIList l = new CTCIList();
		l.append(3);
		l.append(5);
		l.append(8);
		l.append(5);
		l.append(10);
		l.append(2);
		l.append(1);
		l = partition(l.getHead(), 5);
	}
	
	public static CTCIList partition(CTCINode head, int x) {
		CTCIList lessList = new CTCIList();
		CTCIList greaterList = new CTCIList();
		while (head != null) {
			if (head.getData() < x) {
				lessList.append(head.getData());
			} else {
				greaterList.append(head.getData());
			}
			System.out.print("LESS LIST: ");
			lessList.printList();
			System.out.print("BIGG LIST: ");
			greaterList.printList();
			head = head.getNext();
		}
		CTCIList newList = new CTCIList();
		CTCINode lessHead = lessList.getHead();
		while (lessHead != null) {
			newList.append(lessHead.getData());
			lessHead = lessHead.getNext();
		}
		CTCINode greaterHead = greaterList.getHead();
		while (greaterHead != null) {
			newList.append(greaterHead.getData());
			System.out.print("NEW LIST: ");
			newList.printList();
			greaterHead = greaterHead.getNext();
		}
		return newList;
	}

}
