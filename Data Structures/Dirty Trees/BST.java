import java.util.*;
public class BST<E> {
    private Node<E> root;
    private Comparator<? super E> c;
    public BST(Comparator<? super E> c) {
        root = null;
        this.c = c;
    }
    
    public static void main() {
        
    }
    
    public void insert(E data) {
        Node n = new Node(data);
        if(isEmpty())
            root = n;
        else
            insertHelper(root, n);
    }
    private void insertHelper(Node<E> rt, Node<E> toAdd) {
        if(c.compare(toAdd.value, rt.value) < 0)
            if(rt.hasLeftChild())
                insertHelper(rt.leftChild, toAdd);
            else {
                rt.leftChild = toAdd;
                toAdd.parent = rt;
            }
        else
            if(rt.hasRightChild())
                insertHelper(rt.rightChild, toAdd);
            else {
                rt.rightChild = toAdd;
                toAdd.parent = rt;
            }
    }
    
    public boolean search(Node<E> toFind) {
        return searchHelper(root, toFind) != null;
    }
    private Node searchHelper(Node<E> rt, Node<E> i) {
        if(c.compare(rt.value, i.value) == 0)
            return rt;
        else if(c.compare(rt.value, i.value) < 0)
            if(rt.hasLeftChild())
                return searchHelper(rt.leftChild, i);
            else
                return null;
        else
            if(rt.hasRightChild())
                return searchHelper(rt.rightChild, i);
            else
                return null;
    }
    
    public boolean remove(Node<E> data) {
        return removeHelper(searchHelper(root, data));
    }
    private boolean removeHelper(Node x) {
        if(x == null)
            return false;
        else if(x == root)
            root = null;
        else if(x.hasNoChildren()) {//
            if(x.isLeftChild())
                x.parent.leftChild = null;
            else
                x.parent.rightChild = null;
        } else if(x.hasOneChild()) {
            if(x.isRightChild())
                if(x.hasLeftChild())
                    x.parent.rightChild = x.leftChild;
                else
                    x.parent.rightChild = x.rightChild;
            else
                if(x.hasLeftChild())
                    x.parent.leftChild = x.leftChild;
                else
                    x.parent.leftChild = x.rightChild;
        } else {
            Node swap = x;
            swap = swap.rightChild;
            while(swap.leftChild != null)
                swap = swap.leftChild;
            x.value = swap.value;
            removeHelper(swap);
        }
        return true;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrderHelper(root, sb);
        return sb.toString();
    }
    private void inOrderHelper(Node rt, StringBuilder sb) {
        if(rt != null) {
            inOrderHelper(rt.leftChild, sb);
            sb.append(rt.value + " ");
            inOrderHelper(rt.rightChild,sb);
        }
    }
    
    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        preOrderHelper(root, sb);
        return sb.toString();
    }
    private void preOrderHelper(Node rt, StringBuilder sb) {
        if(rt != null) {
            sb.append(rt.value + " ");
            preOrderHelper(rt.leftChild, sb);
            preOrderHelper(rt.rightChild, sb);
        }
    }
    
    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        preOrderHelper(root, sb);
        return sb.toString();
    }
    private void postOrderHelper(Node rt, StringBuilder sb) {
        if(rt != null) {
            preOrderHelper(rt.leftChild, sb);
            preOrderHelper(rt.rightChild, sb);
            sb.append(rt.value + " ");
        }
    }
    
    public String breadthFirstTraversal() {
        StringBuilder sb = new StringBuilder();
        Queue<Node> data = new LinkedList<Node>();
        data.add(root);
        while(!data.isEmpty()) {
            Node p = data.remove();
            if(p != null) {
                sb.append(p + " ");
                data.add(p.leftChild);
                data.add(p.rightChild);
            }
        }
        
        return sb.toString();
    }
    static class Node<E> {
        public E value;
        public Node parent, leftChild, rightChild;
        public Node(E value){
            this.value = value;
        }
        
        public String toString(){
            return(value.toString());
        }
        
        public boolean hasLeftChild(){
            return leftChild == null;
        }
        
        public boolean hasRightChild(){
            return rightChild == null;
        }
        
        public boolean isRoot(){
            return parent == null;
        }
        
        public boolean isLeftChild(){
            return !isRoot() && parent.leftChild == this;
        }
        
        public boolean isRightChild(){
            return !isRoot() && parent.rightChild == this;
        }
        
        public boolean hasNoChildren(){
            return !hasLeftChild() && !hasRightChild();
        }
        
        public boolean hasOneChild(){
            return (hasLeftChild() && !hasRightChild()) || (hasRightChild() && !hasLeftChild());
        }
        
        public boolean hasTwoChildren(){
            return hasLeftChild() && hasRightChild();
        }
    }
}