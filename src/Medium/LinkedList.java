package Medium;

//如何构造一个LinkedList
public class LinkedList {

	Node head; // head of list

	// Linked list Node.
	// This inner class is made static
	// so that main() can access it
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Method to insert a new node 
	public static LinkedList insert(LinkedList list, int data) {
		// Create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty, then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	public static void printList(LinkedList list) {
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}

	public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while (curr != null) {
            next = curr.next; //1. Save next (先把next作为curr.next)
            curr.next = prev; //2. Reverse (然后把curr.next指向前一个元素prev)
            prev = curr;      //3. Move forward prev & curr 
            curr = next;      // (最后把prev和curr分别向前平移一位)
        }
        
        return prev;
    }
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		// Insert the values
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);

		// Print the LinkedList
		printList(list);
		
		System.out.println(reverseList(list.head));
	}
}
