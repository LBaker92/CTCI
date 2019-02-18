package ch2;

public class RemoveDupe {

	public static void main(String[] args) {
		{
			CTCIList list = new CTCIList();
			list.append(10);
			list.append(10);
			list.append(10);
			list.append(20);
			list.append(30);
			list.append(30);
			list.append(40);
			list.removeDupes();
			System.out.println();
		}
		
		{
			CTCIList list = new CTCIList();
			list.append(10);
			list.append(10);
			list.append(10);
			list.append(20);
			list.append(30);
			list.append(30);
			list.append(40);
			list.removeDupesRunner();
			System.out.println();
		}
	}
}
