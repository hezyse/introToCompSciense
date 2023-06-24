public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot()
    {
        return root;
    }

    public static void main(String[] args) {
        // Create a binary tree
        BinaryTree tree = new BinaryTree();
        tree.insert(99);
        tree.root.left = new Node(82);
        tree.root.left.left = new Node(25);
        tree.root.left.left.right = new Node(18);
        tree.root.left.left.right.right = new Node(2);
        tree.root.left.right = new Node(77);
        tree.root.left.right.right = new Node(61);
        tree.root.left.right.right.right = new Node(54);
        tree.root.left.right.right.left = new Node(42);
        tree.root.left.right.right.left.right = new Node(32);

        /*tree.insert(82);
        tree.insert(77);
        tree.insert(61);
        tree.insert(54);
        tree.insert(42);
        tree.insert(32);
        tree.insert(25);
        tree.insert(18);
        tree.insert(2);*/



        // Traverse the binary tree
        System.out.println("\nPostorder traversal:");
        tree.postorderTraversal(tree.root);

        System.out.println("\nInorder traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPreorder traversal:");
        tree.preorderTraversal(tree.root);



        System.out.println("\n"+what(tree.getRoot()));
    }

    // Inorder traversal
    void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    // Postorder traversal
    void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Preorder traversal
    void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }



    // Insert a node into the binary tree
    void insert(int data) {
        root = insertNode(root, data);
    }

    // Helper method to recursively insert a node into the binary tree
    Node insertNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data)
            node.left = insertNode(node.left, data);
        else if (data > node.data)
            node.right = insertNode(node.right, data);

        return node;
    }

    public static int what(Node t)
    {
        if(t.getLeftSon() == null && t.getRightSon() == null)
            return 0;
        if(t.getLeftSon() != null && t.getRightSon() != null)
            return 2+ what(t.getLeftSon()) + what(t.getRightSon());
        if(t.getLeftSon() != null)
            return 1 + what(t.getLeftSon());
        return 1 + what(t.getRightSon());
    }
}
