package player;

public class MyLinkedList {
	private NodeMove start;
	private NodeMove end;
	//start -> next -> end
	
	public MyLinkedList() {
		start = null;
		end = null;
	}
	
	public NodeMove getHead() {
		return start;
	}
	
	public void add(NodeMove node) {
		if(start == null) {
			start = node;
			end = node;
		}
		else {
			end.next = node;
			end = node;
		}
	}
}
