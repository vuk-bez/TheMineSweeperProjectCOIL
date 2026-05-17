package player;

public class NodeMove {
	NodeMove next;
	Move data;
	
	public NodeMove(Move data) {
		this.data = data;
	}
	public NodeMove(Move data, NodeMove next) {
		this.data = data;
		this.next = next;
	}
}
