public class LocationTree {
    private TreeNode root;

    private class TreeNode {
        String location;
        TreeNode left, right;
        int height;

        TreeNode(String location) {
            this.location = location;
            this.height = 1;
        }
    }

    public void insert(String location) {
        root = insert(root, location);
    }

    private TreeNode insert(TreeNode node, String location) {
        if (node == null)
            return new TreeNode(location);

        int cmp = location.compareTo(node.location);
        if (cmp < 0)
            node.left = insert(node.left, location);
        else if (cmp > 0)
            node.right = insert(node.right, location);
        else
            return node; // Duplicate not allowed

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && location.compareTo(node.left.location) < 0)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && location.compareTo(node.right.location) > 0)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && location.compareTo(node.left.location) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && location.compareTo(node.right.location) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void displayLocations() {
        if (root == null) {
            System.out.println("No locations in the tree!");
            return;
        }
        System.out.println("Locations (sorted alphabetical order):");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.location + " ");
            inOrderTraversal(node.right);
        }
    }

    private int height(TreeNode node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(TreeNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private String minValue(TreeNode node) {
        String minValue = node.location;
        while (node.left != null) {
            minValue = node.left.location;
            node = node.left;
        }
        return minValue;
    }

    public void remove(String location) {
        root = remove(root, location);
    }

    private TreeNode remove(TreeNode node, String location) {
        if (node == null)
            return node;

        int cmp = location.compareTo(node.location);
        if (cmp < 0) {
            node.left = remove(node.left, location);
        } else if (cmp > 0) {
            node.right = remove(node.right, location);
        } else {
            // Node to be deleted
            if (node.left == null || node.right == null) {
                TreeNode temp = node.left != null ? node.left : node.right;
                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                TreeNode temp = minValueNode(node.right);
                node.location = temp.location;
                node.right = remove(node.right, temp.location);
            }
        }

        if (node == null)
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
