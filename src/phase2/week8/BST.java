package phase2.week8;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向BST中新增新的元素e，遞迴
    public void add(E e) {
        root = add(root, e);
    }

    //向以node為根的BST中插入元素E，遞迴
    //回傳插入新節點後BST的根
    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    // 向BST中新增新的元素e，非遞歸寫法
    public void addNR(E e) {

        // 對BST是空的情況特殊處理
        // 此時，直接讓 root 指向新的節點即可
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }

        // 用 p 來跟蹤待插入節點的上一個節點
        // p 的作用相當於鏈表插入節點時，pre 的作用
        Node p = root;
        while (p != null) {

            // 如果待插入的值小於目前 p 節點的值
            // 說明新插入的值要放在 p 的左子樹
            if (e.compareTo(p.e) < 0) {
                // 如果 p 的左子樹為空，則在 p.left 上放入新的節點
                if (p.left == null) {
                    p.left = new Node(e);
                    size++;
                    return; // 注意這里直接 return
                }

                // 否則 p = p.left
                p = p.left;
            }
            // 如果待插入的值大於目前 p 節點的值
            // 說明新插入的值要放在 p 的右子樹
            else if (e.compareTo(p.e) > 0) {
                // 如果 p 的右子樹為空，則在 p.right 上放入新的節點
                if (p.right == null) {
                    p.right = new Node(e);
                    size++;
                    return; // 注意這里直接 return
                }

                // 否則 p = p.right
                p = p.right;
            }
            // 如果待插入的值等於目前 p 節點的值，說明BST中已經有這個值了
            // 直接 return
            else return;
        }
    }

    //BST中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    //看以node為根的BST中是否包含元素e，遞迴
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else //e.compareTo(node.e) > 0
            return contains(node.right, e);
    }

    //BST Preorder Traversal
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {

        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

        // if(node !=null) {
        //     System.out.println(node.e);
        //     preOrder(node.left);
        //     preOrder(node.right);
        // }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    //產生以node為節點，深度為depth的描述二元樹的字串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        bst.preOrder();
        System.out.println();
        System.out.println(bst);
    }
}
