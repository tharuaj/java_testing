class Order {
    int[] treeArray;

    public Order(int[] array) {
        treeArray = array;
    }
//To traverse a binary tree in preorder, you follow the order: Root -> Left -> Right.

    void preorderTraversal(int index) {
        if (index >= treeArray.length) {
            return;
        }

        // Visit the node at index
        System.out.print(treeArray[index] + " ");

        preorderTraversal(2 * index + 1);
        preorderTraversal(2 * index + 2);
    }

    // Wrapper method to start traversal from the root
    void preorder() {
        preorderTraversal(0);
    }

//Inorder traversal follows the order: Left -> Root -> Right.
    void inorderTraversal(int index) {
        if (index >= treeArray.length) {
            return;
        }

        inorderTraversal(2 * index + 1);
        System.out.print(treeArray[index] + " ");
        inorderTraversal(2 * index + 2);
    }

    void inorder() {
        inorderTraversal(0);
    }

//In postorder traversal, the order is: Left -> Right -> Root.
    void postorderTraversal(int index) {
        if (index >= treeArray.length) {
            return;
        }

        postorderTraversal(2 * index + 1);
        postorderTraversal(2 * index + 2);
        System.out.print(treeArray[index] + " ");
    }

    void postorder() {
        postorderTraversal(0);
    }

    public static void main(String[] args) {
        int[] treeArray = {1, 2, 3, 4, 5, 9,13,19};

        Order tree = new Order(treeArray);//passing argument to constructor

        System.out.println("Preorder traversal: ");
        tree.preorder();  // Output: 1 2 4 5 3
        System.out.println();

        System.out.println("Inorder traversal: ");
        tree.inorder();  // Output: 1 2 4 5 3
        System.out.println();

        System.out.println("Postorder traversal: ");
        tree.postorder();  // Output: 1 2 4 5 3
        System.out.println();

    }
}
