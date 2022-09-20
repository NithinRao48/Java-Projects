package TrafficCrashAnalysisChicago;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * BinaryTreeLL.java - Binary tree constructed using a Linked List
 * @author nsrao
 *
 */
public class BinaryTreeLL {
	
	/**
	 * Insert a TrafficAccident Data into Linked List
	 * @param head head of the linked list
	 * @param data Traffic accident data
	 * @return	linked list node with the above data
	 */
    public static LinkedListNode push(LinkedListNode head, TrafficAccident data)
    {
        LinkedListNode node = new LinkedListNode(data);
        node.next = head;
        node.data = data;
        return node;
    }

    /**
	 * Function to print inorder traversal of the tree.
	 * @param root root of the tree
	 */
	static void InOrder(Node root)
	{
		if (root != null) {
			preOrder(root.left);
			root.data.printInfo();
			preOrder(root.right);
		}
	}
	
	/**
	 * Function to print preorder traversal of the tree.
	 * @param root root of the tree
	 */
	static void preOrder(Node root)
	{
		if (root != null) {
			root.data.printInfo();
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	/**
	 * Function to print postorder traversal of the tree.
	 * @param root root of the tree
	 */
	static void postOrder(Node root)
	{
		if (root != null) {
			preOrder(root.left);
			preOrder(root.right);
			root.data.printInfo();
		}
	}
	
    /**
     * Function to construct a complete binary tree from a given linked list
     * @param head head of the linked list 
     * @return binary tree root node
     */
    public static Node convertListToBinaryTree(LinkedListNode head)
    {
        if (head == null) {
            return null;
        }
 
        Node root = new Node(head.data);
        head = head.next;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (head != null)
        {
        	Node front = q.poll();
            front.left = new Node(head.data);
            q.add(front.left);
            head = head.next;

            if (head != null)
            {
                front.right = new Node(head.data);
                q.add(front.right);
                head = head.next;
            }
        }
        return root;
    }


}
