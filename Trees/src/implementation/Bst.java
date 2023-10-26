package implementation;

public class Bst {
    private class Node {

        int key;
        Node left, right;

        Node(int value) {
            key = value;
            left = null;
            right = null;
        }
    }

    Node root;

    Bst() {
        root = null;
    }

    boolean searchRecursive(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (root.key > key) {
            return searchRecursive(root.left, key);
        } else {
            return searchRecursive(root.right, key);
        }
    }

    boolean search(int value) {
        Node temp = root;
        while (temp != null) {
            if (temp.key == value) {
                return true;
            } else if (temp.key > value) {
                temp = temp.left;
            } else
                temp = temp.right;
        }
        return false;
    }

    void insertNode(int value) {
        Node node = new Node(value);
        if (root == null)
            root = node;
        else {
            Node temp = root;
            while (temp != null) {
                if (temp.key > value) {
                    if (temp.left == null) {
                        temp.left = node;
                        return;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = node;
                        return;
                    } else
                        temp = temp.right;
                }
            }
        }
    }

    void delete(int value) {
        Node temp = root;
        Node parent = null;
        while (temp != null) {
            if (temp.key > value) {
                parent = temp;
                temp = temp.left;
            } else if (temp.key < value) {
                parent = temp;
                temp = temp.right;
            } else {
                // if( temp have no child )
                if (temp.left == null && temp.right == null) {
                    if (parent.key > value)
                        parent.left = null;
                    else
                        parent.right = null;
                    break;
                }
                // if temp have only left chile
                else if (temp.right == null && temp.left != null) {
                    if (parent.key > value)
                        parent.left = temp.left;
                    else
                        parent.right = temp.left;
                    break;
                }

                // if temp have only right child
                else if (temp.left == null && temp.right != null) {
                    if (parent.key > value)
                        parent.left = temp.right;
                    else
                        parent.right = temp.right;
                    break;
                } else {
                    temp.key = findSuccessor(temp.right).key;
                    value = temp.key;
                    temp = temp.right;
                }

            }
        }
    }

    Node deleteImporveVersion(Node root, int value) {
        Node current = root;
        Node parent = null;
        while (current != null && current.key != value) {
            parent = current;
            if (current.key > value)
                current = current.left;
            else
                current = current.right;
        }

        // we have not fond the node
        if (current == null) {
            return current;
        }
        // we fond the node
        // and left node is null
        if (current.left == null) {
            // if we fond root to be deleted;
            if (parent == null) {
                return current.right;
            }
            // if current is left child of his parent;
            if (parent.left == current)
                parent.left = current.right;
            // if current is right child of his parent
            else
                parent.right = current.right;
        }
        // right node is null
        else if (current.right == null) {
            // if we fond root to be deleted;
            if (parent == null) {
                return current.left;
            }
            // if current is left child of his parent;
            if (parent.left == current)
                parent.left = current.left;
            // if current is right child of his parent
            else
                parent.right = current.left;

        }
        // if both child is not null;
        else {
            Node successor = findSuccessor(current.right);
            current.key = successor.key;
            current.right = deleteImporveVersion(current.right, current.key);
        }
        return root;

    }

    Node deleteRecursivly(Node root, int value) {
        if (root == null)
            return null;
        if (root.key > value) {
            root.left = deleteRecursivly(root.left, value);
        } else if (root.key < value) {
            root.right = deleteRecursivly(root.right, value);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                root.key = findSuccessor(root.right).key;
                root.right = deleteRecursivly(root.right, root.key);
            }
        }
        return root;
    }

    Node findSuccessor(Node root) {
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);

        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }

    void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.key + " ");
    }

    public static void main(String[] args) {
        Bst bst = new Bst();
        bst.insertNode(50);
        bst.insertNode(30);
        bst.insertNode(70);
        bst.insertNode(20);
        bst.insertNode(40);
        bst.inorderTraversal(bst.root); // Output: 20 30 40 50 60 70 80
        System.out.println();
        bst.delete(20);
        bst.deleteRecursivly(bst.root, 40);
        bst.inorderTraversal(bst.root); // Output: 20 30 40 50 60 70 80
        bst.deleteRecursivly(bst.root, 45);
        bst.insertNode(60);
        System.out.println();
        bst.insertNode(80);
        bst.inorderTraversal(bst.root); // Output: 20 30 40 50 60 70 80
        System.out.println();
    }
}
