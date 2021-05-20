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
			next = curr.next; // 1. Save next (先把next作为curr.next)
			curr.next = prev; // 2. Reverse (然后把curr.next指向前一个元素prev)
			prev = curr; // 3. Move forward prev & curr
			curr = next; // (最后把prev和curr分别向前平移一位)
		}

		return prev;
	}

	public int length(Node head) {
		int length = 0;
		Node currNode = head;

		while (currNode != null) {
			length++;
			currNode = currNode.next;
		}

		return length;
	}

	// 删除某个值为val的结点：
	public void deleteNode(int val) {
		Node curr = head;
		Node prev = head;

		// 假如第一个就是要删除的,直接next
		if (curr.data == val) {
			head = curr.next;
			return;
		}

		// 遍历list，跳过那些值不为val的节点
		while (curr != null && curr.data != val) {
			prev = curr;
			curr = curr.next;
		}
		
		// 没有找到要删除的，return
		if (curr.next == null) return;

		// 如果找到了，就删除
		prev.next = curr.next;
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
