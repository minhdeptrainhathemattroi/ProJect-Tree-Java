package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeAlgorithms {
    /**
     * Performs a pre-order traversal of a binary tree.
     * @param root Root of binary tree.
     * @param <T> Type of node payload.
     * @return A Collection containing the node payloads in traversal order.
     */

    public static <T> List<T> preOrder(BinaryNode<T> root) {
        List<T> minh= new LinkedList<>();
        List<T> depTrai= new ArrayList<>();
        if(root!=null){
            depTrai.add(root.payload);
            depTrai.addAll(preOrder(root.left));
            depTrai.addAll(preOrder(root.right));
        }
        minh.addAll(depTrai);
        return minh;
    }

    /**
     * Performs a in-order traversal of a binary tree.
     * @param root Root of binary tree.
     * @param <T> Type of node payload.
     * @return A Collection containing the node payloads in traversal order.
     */
    public static <T> List<T> inOrder(BinaryNode<T> root) {
        List<T> minh= new LinkedList<>();
        List<T> depTrai= new ArrayList<>();
        if (root != null) {
            depTrai.addAll(inOrder(root.left));
            depTrai.add(root.payload);
            depTrai.addAll(inOrder(root.right));
        }
        minh.addAll(depTrai);
        return minh;

        /* YOUR CODE HERE */}

    /**
     * Performs a post-order traversal of a binary tree.
     * @param root Root of binary tree.
     * @param <T> Type of node payload.
     * @return A Collection containing the node payloads in traversal order.
     */
    public static <T> List<T> postOrder(BinaryNode<T> root) {
        List<T> minh= new ArrayList<>();
        List<T> depTrai= new ArrayList<>();
        if(root!=null){
            depTrai.addAll(postOrder(root.left));
            depTrai.addAll(postOrder(root.right));
            depTrai.add(root.payload);
        }
        minh.addAll(depTrai);
        return minh;

    }

    /**
     * Conduct a binary search on a binary search tree for a target value.
     * @param root Root of the binary search tree.
     * @param value The value to search for.
     * @return The node containing the value, or null if the value is not present in the tree.
     */
    public static BinaryNode<Integer> binarySearch(BinaryNode<Integer> root, Integer value) {
        if(root==null){
            return null;
        }
        else if(value.equals(root.payload)){
            return root;
        }

        else if(root.payload<value){
            return binarySearch(root.right,value);
        }
        else {
            return binarySearch(root.left,value);
        }
    }

    /**
     * Inserts an Integer value into a Binary Search Tree.
     * @param root Root of the binary search tree.
     * @param value The value to insert.
     * @return The BinaryNode containing the newly inserted value, or an existing BinaryNode with an equal value.
     */
    public static BinaryNode<Integer> insert(BinaryNode<Integer> root, Integer value) {
        if(root==null){
            return new BinaryNode<>(value);
        }
        else{
            if(value<root.payload){
                if(root.left==null){
                root.left=insert(root.left,value);
                return root.left;
                }
                return  insert(root.left,value);
        }
            else if(value>root.payload){
                 if(root.right==null){
                root.right=insert(root.left,value);
                 return root.right;}
                 return insert(root.right,value);
        }
}
        return root;
    }

    /**
     * Determines if two BSTs are equal in value.
     * @param A Root of first tree.
     * @param B Root of second tree.
     * @return True or false depending on the equality of the two trees.
     */
    public static boolean equals(BinaryNode<Integer> A, BinaryNode<Integer> B) {
        if(A==null&&B==null){
            return true;
        }

        if(A!=null&&B!=null){
            return A.payload.equals(B.payload)&& equals(A.right,B.right)&&equals(A.left,B.left);
        }
        return false;

        /* YOUR CODE HERE */
    }

    /**
     * Finds the path from the tree root to a target element.
     * This algorithm does NOT assume the tree is a Binary Search Tree,
     * only that it is a Binary Tree.
     *
     * Hint: This method is a bit harder than the ones above.
     * Consider implementing some TreeAlgorithms first to get some more recursion practice.
     *
     * Hint: You can use the LinkedList::addAll method to append all the contents of
     * another list to a list (like a join, but copies and is non-destructive).
     * You may also use the LinkedList::addFirst method to push to the front of the list.
     *
     * @param root Root of the tree.
     * @param value The value to search for.
     * @param <T> The type of the value to search for.
     * @return A LinkedList of Directions that lead to the target value.
     * If the target value is at the root element, return an empty list.
     * If the target value is not present in the tree, return null.
     */
    public static <T> LinkedList<BinaryNode.Direction> path(BinaryNode<T> root, T value) {
        LinkedList<BinaryNode.Direction> depTrai=new LinkedList<>();
        if(root==null){
            return null;
        }

        else if(root.payload==value){
            return depTrai;
        }

        if(root.left!=null){
            if(root.left.payload==value){depTrai.add(BinaryNode.Direction.left);
            return depTrai;}
            else if(path(root.left,value)!=null){
                depTrai.add(BinaryNode.Direction.left);
                depTrai.addAll(path(root.left,value));

            }
        }
        if(root.right!=null){
            if(root.right.payload==value){depTrai.add(BinaryNode.Direction.right);
            return depTrai;}
            else if(path(root.right,value)!=null){
                depTrai.add(BinaryNode.Direction.right);
                depTrai.addAll(path(root.right,value));

            }
        }
        if(depTrai.isEmpty()){return null;}


        /* YOUR CODE HERE */
        return depTrai;
}
}
