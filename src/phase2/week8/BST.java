package phase2.week8;

import java.util.*;

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
        //     preOrder(node.righ t);
        // }
    }

    //BST的非遞迴前序遍歷
    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索樹的層序遍歷
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    //尋找BST的最小元素
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).e;
    }

    //回傳以node為根的BST的最小值所在的節點
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private E minimumNR() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        Node cur = root;
        while (cur.left != null)
            cur = cur.left;
        return cur.e;
    }

    //尋找BST的最大元素
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maximum(root).e;
    }

    //回傳以node為根的BST的最大值所在的節點
    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    private E maximumNR() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        Node cur = root;
        while (cur.right != null)
            cur = cur.right;
        return cur.e;
    }

    //從BST中刪除最小值所在節點，回傳最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    //刪除掉以Node韋根的BST翁最小節點
    //回傳刪除解點後新的BST的根
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //從BST中刪除最大值所在節點
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    //刪除掉以node為根的BST中的最大節點
    //回傳刪除節點後新的BST的根
    public Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //從BST中刪除元素為e的節點
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node ,E e){
        if(node == null)
            return null;

        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right,e);
            return node;
        }
        else { //e.compareTo(node.e) == 0

            //待刪除節點左子樹為空的情況
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待刪除節點右子樹為空的情況
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
        }

        //待刪除節點左右子樹均不為空的情況
        //找到比待刪除節點大的最小節點，即待刪除節點右子樹的最小結點
        //用這個節點頂替刪除節點的位置
        Node successor = minimum(node.right);
        successor.right = removeMin(node.right);
        successor.left = node.left;

        node.left = node.right = null;

        return successor;
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
        Random random = new Random();
        int n = 1000;

        //test removeMin
        for (int i = 0; i < n; i++)
            bst.add(random.nextInt(10000));

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMin());

        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++)
            if (nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error");
        System.out.println("removeMin test completed");

        //test removeMax
        for (int i = 0; i < n; i++)
            bst.add(random.nextInt(10000));

        nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMax());
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++)
            if (nums.get(i - 1) < nums.get(i))
                throw new IllegalArgumentException("Error");
        System.out.println("removeMax test completed.");
    }
}
