package TrafficCrashAnalysisChicago;

/**
 * BinarySearchAVLTreeLL.java - Balanced Binary search tree (AVL) 
 * @author nsrao
 *
 */
public class BinarySearchAVLTreeLL {
		
		/**
		 * Function to get height of the tree
		 * @param N	Node of the tree
		 * @return height of the node
		 */
		int height(Node N)
		{
			if (N == null)
				return 0;
			return N.height;
		}

		/**
		 * Function that allocates a new node with the given TrafficAccident Data.
		 * @param data 	Traffic accident data
		 * @return	new node with this data
		 */
		 Node newNode(TrafficAccident data)
		{
			Node node = new Node();
			node.data = data;
			node.left = null;
			node.right = null;
			node.height = 1; // new node is initially added at leaf
			node.count = 1;
			return (node);
		}

		/**
		 * Function to right rotate subtree 
		 * @param y Node of the tree
		 * @return Node after right rotation
		 */
		 Node rightRotate(Node y)
		{
			Node x = y.left;
			Node T2 = x.right;

			// Perform rotation
			x.right = y;
			y.left = T2;

			// Update heights
			y.height = Math.max(height(y.left), height(y.right)) + 1;
			x.height = Math.max(height(x.left), height(x.right)) + 1;

			// Return new root
			return x;
		}
		

		/**
		 * Function to left rotate subtree 
		 * @param x Node of the tree
		 * @return	Node after left rotation
		 */
		 Node leftRotate(Node x)
		{
			Node y = x.right;
			Node T2 = y.left;

			// Perform rotation
			y.left = x;
			x.right = T2;

			// Update heights
			x.height = Math.max(height(x.left), height(x.right)) + 1;
			y.height = Math.max(height(y.left), height(y.right)) + 1;

			// Return new root
			return y;
		}

		/**
		 * Get Balancing factor of node N
		 * @param N Node of the tree
		 * @return	balance factor of the node
		 */
		 int getBalance(Node N)
		{
			if (N == null)
				return 0;
			return height(N.left) - height(N.right);
		}

		/**
		 * Function to insert TrafficAccident Data based on Vehicle ID.
		 * @param node	node of the tree
		 * @param data	Traffic accident data
		 * @return root the tree inserted based on vehicle ID
		 */
		 Node insertByVehicleId(Node node, TrafficAccident data)
		{
			if (node == null)
				return (newNode(data));
			
			if (Integer.parseInt(data.getVehicleId()) == Integer.parseInt(node.data.getVehicleId())) {
				node.duplicateEntries.add(data);
				return node;
			}
			if (Integer.parseInt(data.getVehicleId()) < Integer.parseInt(node.data.getVehicleId()))
				node.left = insertByVehicleId(node.left, data);
			else
				node.right = insertByVehicleId(node.right, data);
			
			node.height = Math.max(height(node.left), height(node.right)) + 1;

			int balance = getBalance(node);
			if (balance > 1 && Integer.parseInt(data.getVehicleId()) < Integer.parseInt(node.left.data.getVehicleId()))
				return rightRotate(node);

			if (balance < -1 && Integer.parseInt(data.getVehicleId()) > Integer.parseInt(node.right.data.getVehicleId()))
				return leftRotate(node);

			if (balance > 1 && Integer.parseInt(data.getVehicleId()) > Integer.parseInt(node.left.data.getVehicleId())) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}

			if (balance < -1 && Integer.parseInt(data.getVehicleId()) < Integer.parseInt(node.right.data.getVehicleId())) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}

			return node;
		}

		/**
		 * Function to insert TrafficAccident Data based on City Name.
		 * @param node node of the tree
		 * @param data	Traffic accident data
		 * @return root the tree inserted based on city name
		 */
		 Node insertByCity(Node node, TrafficAccident data)
		{
			if (node == null)
				return (newNode(data));

			if (data.getCity().equals(node.data.getCity())) {
				node.duplicateEntries.add(data);
				(node.count)++; 
				return node;
			}

			if (data.getCity().compareTo(node.data.getCity()) <0)
				node.left = insertByCity(node.left, data);
			else
				node.right = insertByCity(node.right, data);

			node.height = Math.max(height(node.left), height(node.right)) + 1;
			int balance = getBalance(node);

			if (balance > 1 && data.getCity().compareTo(node.left.data.getCity()) <0)
				return rightRotate(node);

			if (balance < -1 && data.getCity().compareTo(node.right.data.getCity()) > 0)
				return leftRotate(node);

			if (balance > 1 && data.getCity().compareTo(node.left.data.getCity()) > 0) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}

			if (balance < -1 && data.getCity().compareTo(node.right.data.getCity()) < 0) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
			
			return node;
		}

		/**
		 * Function to insert TrafficAccident Data based on RD No.
		 * @param node	node of the tree
		 * @param data	Traffic accident data
		 * @return	root of the tree inserted based on rd Number
		 */
		Node insertByRDNo(Node node, TrafficAccident data)
		{
			if (node == null)
				return (newNode(data));

			if (data.getRD_NO().equals(node.data.getRD_NO())) {
				node.duplicateEntries.add(data);
				(node.count)++; 
				return node;
			}

			if (data.getRD_NO().compareTo(node.data.getRD_NO()) <0)
				node.left = insertByRDNo(node.left, data);
			else
				node.right = insertByRDNo(node.right, data);

			node.height = Math.max(height(node.left), height(node.right)) + 1;

			int balance = getBalance(node);


			if (balance > 1 && data.getRD_NO().compareTo(node.left.data.getRD_NO()) <0)
				return rightRotate(node);

			if (balance < -1 && data.getRD_NO().compareTo(node.right.data.getRD_NO()) > 0)
				return leftRotate(node);

			if (balance > 1 && data.getRD_NO().compareTo(node.left.data.getRD_NO()) > 0) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}

			if (balance < -1 && data.getRD_NO().compareTo(node.right.data.getRD_NO()) < 0) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}

			return node;
		}
		
		
		/**
		 * Function to insert TrafficAccident Data based on Crash Date.
		 * @param node	node of the tree
		 * @param data Traffic accident data
		 * @return root of the tree inserted based on crash Date
		 */
		Node insertByDate(Node node, TrafficAccident data)
		{
			if (node == null)
				return (newNode(data));

			if (data.getCrashDate().equals(node.data.getCrashDate())) {
				node.duplicateEntries.add(data);
				(node.count)++; 
				return node;
			}

			if (data.getCrashDate().compareTo(node.data.getCrashDate()) <0)
				node.left = insertByDate(node.left, data);
			else
				node.right = insertByDate(node.right, data);

			node.height = Math.max(height(node.left), height(node.right)) + 1;


			int balance = getBalance(node);

			if (balance > 1 && data.getCrashDate().compareTo(node.left.data.getCrashDate()) <0)
				return rightRotate(node);

			if (balance < -1 && data.getCrashDate().compareTo(node.right.data.getCrashDate()) > 0)
				return leftRotate(node);

			if (balance > 1 && data.getCrashDate().compareTo(node.left.data.getCrashDate()) > 0) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}

			if (balance < -1 && data.getCrashDate().compareTo(node.right.data.getCrashDate()) < 0) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}

			return node;
		}
		
		/**
		 * Function to insert TrafficAccident Data based on PersonID.
		 * @param node node of the tree
		 * @param data	Traffic accident data
		 * @return root of the tree inserted based on person ID
		 */
		Node insertByPersonId(Node node, TrafficAccident data)
		{
			if (node == null)
				return (newNode(data));

			if (data.getPersonID().equals(node.data.getPersonID())) {
				node.duplicateEntries.add(data);
				(node.count)++; 
				return node;
			}

			if (data.getPersonID().compareTo(node.data.getPersonID()) <0)
				node.left = insertByPersonId(node.left, data);
			else
				node.right = insertByPersonId(node.right, data);

			node.height = Math.max(height(node.left), height(node.right)) + 1;

			int balance = getBalance(node);

			if (balance > 1 && data.getPersonID().compareTo(node.left.data.getPersonID()) <0)
				return rightRotate(node);

			if (balance < -1 && data.getPersonID().compareTo(node.right.data.getPersonID()) > 0)
				return leftRotate(node);

			if (balance > 1 && data.getPersonID().compareTo(node.left.data.getPersonID()) > 0) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}

			if (balance < -1 && data.getPersonID().compareTo(node.right.data.getPersonID()) < 0) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}

			return node;
		}

		
		/**
		 * Function to return the node with least value
		 * @param node node of the tree
		 * @return left most node of the tree
		 */
		Node minValueNode(Node node)
		{
			Node current = node;
			while (current.left != null)
				current = current.left;

			return current;
		}

		
				
		/**
		 * Function to print inorder traversal of the tree.
		 * @param root root node of the tree
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
		 * @param root root node of the tree
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
		 * @param root root node of the tree
		 */
		static void postOrder(Node root)
		{
			if (root != null) {
				preOrder(root.left);
				preOrder(root.right);
				root.data.printInfo();
			}
		}
}
