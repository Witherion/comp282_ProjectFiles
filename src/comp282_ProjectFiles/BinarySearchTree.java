package comp282_ProjectFiles;

public class BinarySearchTree<E extends Comparable<E>> {

    public class Node<E extends Comparable<E>> {

        E data;
        Node<E> left;
        Node<E> right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Returns the root node of the Binary Search Tree (BST).
     * This method is essential to prevent the program from failing by providing access to the root node.
     *
     * @return the root node of the BST
     */
    public Node<E> returnRoot() {
        return root;
    }

    public boolean find(E data) {
        Node<E> node = root;
        while (node != null) {
            if (node.data.equals(data)) {
                return true;
            } else if (node.data.compareTo(data) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false; //returns False since E does not exist
    }

    public void insert(E data) {
        root = insertAssist(root, data);
    } //inserts an E item into the BST

    Node<E> insertAssist(Node<E> root, E data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        } else if (data.compareTo(root.data) < 0) {
            root.left = insertAssist(root.left, data);
        } else {
            root.right = insertAssist(root.right, data);
        }
        return root;
    }

    public void delete(E data) {
        root = deleteAssist(root, data);
    } //deletes Item E

    Node<E> deleteAssist(Node<E> root, E data) {
        if (root == null) {
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = deleteAssist(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteAssist(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = successor(root.right);
            root.right = deleteAssist(root.right, root.data);
        }
        return root;
    }

    E successor(Node<E> root) {
        E successor = root.data;
        while (root.left != null) {
            successor = root.left.data;
            root = root.left;
        }
        return successor;
    }

    public int treeHeight() { //returns height of BST (Should be 0 or greater)
        return height(root);
    }

    int height(Node<E> node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public int itemHeight(E data) {
        return itemHeightAssist(root, data);
    } //returns the height of E item else return -1

    int itemHeightAssist(Node<E> root, E data) {
        if (root == null) {
            return -1;
        }
        if (data.compareTo(root.data) == 0) {
            return height(root);
        }
        int leftHeight = itemHeightAssist(root.left, data);
        if (leftHeight != -1) {
            return leftHeight;
        }
        return itemHeightAssist(root.right, data);
    }

    public int leftHeight(E data) {
        Node<E> node = findNode(root, data);
        if (node == null || node.left == null) {
            return -1;
        }
        return height(root.left);
    } // returns the height of the left subtree for E item

    public int rightHeight(E data) {
        Node<E> node = findNode(root, data);
        if (node == null || node.right == null) {
            return -1;
        }
        return height(root.right);
    } //returns the height of the right subtree for E item

    Node<E> findNode(Node<E> node, E data) {
        if (node == null || node.data.equals(data)) {
            return node;
        }
        if (node.data.compareTo(data) > 0) {
            return findNode(node.left, data);
        } else {
            return findNode(node.right, data);
        }
    }

    public boolean isLeaf(E data) {
        Node<E> node = findLeaf(root, data);
        return node != null && node.left == null && node.right == null;
    } //returns true if E item is a leaf else false

    Node<E> findLeaf(Node<E> root, E data) {
        if (root == null || data.compareTo(root.data) == 0) {
            return root;
        } else {
            return data.compareTo(root.data) < 0 ? findLeaf(root.left, data) : findLeaf(root.right, data);
        }
    }

    public int status(E data) {
        if (root == null) {
            return -1;
        } else if (root == data) {
            return 0;
        } else if (root.left == data) {
            return 1;
        } else {
            return 2;
        }
    } //returns 0 - root, 1 - left child, 2 - right child

    public void display() {
        displayAssist(root);
        System.out.println();
    }

    void displayAssist(Node<E> root) {
        if (root != null) {
            displayAssist(root.right);
            System.out.print(root.data + " ");
            displayAssist(root.left);
        }
    }

}
