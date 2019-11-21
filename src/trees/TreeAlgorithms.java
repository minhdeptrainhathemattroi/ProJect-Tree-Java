package trees;





import java.util.*;

public class TreeAlgorithms {
    /**
     * Finds the maximum Integer in a tree.
     * @param root Root of the tree.
     * @return The maximum Integer contained in the tree; null if the root is null.
     */
    public static Integer max(TreeNode<Integer> root) {
        if(root==null){
            return null;
        }
        else if(root.children==null){
            return root.payload;
        }
        else{
        Integer current= root.payload;
        for(TreeNode<Integer> minh: root.children){
            Integer nextMax= max(minh);
            if(nextMax==null||current.compareTo(nextMax)>0){
                return current;
               }
            else{
                current=nextMax;
               }
        }
        return current;
        }


    }

    /**
     * Finds the minimum Integer in a tree.
     * @param root Root of the tree.
     * @return The minimum Integer contained in the tree; null if the root is null.
     */
    public static Integer min(TreeNode<Integer> root) {
        if(root==null){
            return null;
        }
        if(root.children==null){
            return root.payload;
        }
        else{
            int current= root.payload;

            for(TreeNode<Integer> minh: root.children){
                Integer nextMin= min(minh);
                if(nextMin<current){
                    current=nextMin;
                }
            }
            return current;
        }

    }

    /**
     * Finds all the tree leaves (nodes with no children) in a tree.
     * @param root Root of the tree.
     * @return A LinkedList of leaf TreeNodes from the tree.
     */
    public static LinkedList<TreeNode<Integer>> leaves(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> minh= new LinkedList<>();
        if(root!=null){
            if(root.children.size()==0){
                minh.add(root);}


            for(TreeNode<Integer> depTrai: root.children){
                minh.addAll(leaves(depTrai));
            }
        }
        /* YOUR CODE HERE */
        return minh;
    }

    /**
     * Counts the number of nodes in a tree.
     * @param root Root of the tree.
     * @return
     */
    public static int count(TreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        if(root.children.size()==0){
            return 1;
        }
        int depTrai=1;
        for(TreeNode<Integer> minh: root.children){
            depTrai+=count(minh);
        }
        return depTrai;

    }

    /**
     * Computes the depth (height) of a tree.
     * A single node by itself has zero depth;
     * a single node and a single child has a depth of 1.
     * @param root Root of the tree.
     * @return The depth (height) of the tree.
     */
    public static <T> int depth(TreeNode<T> root) {
        if(root==null|| root.children == null || root.children.size()==0){
            return 0;
        }
        int max = 0;

        for(TreeNode<T> minh: root.children){
            int a = 1 + depth(minh);
            if (max < a)
                max = a;
        }
        return max;
    }

    /**
     * Determines if two trees are equal in value.
     * @param A Root of the first tree.
     * @param B Root of the second tree.
     * @param <T> Type of value contained by the tree.
     * @return True or false depending on the equality of the two trees.
     */
    public static <T> boolean equals(TreeNode<T> A, TreeNode<T> B) {

        if(A==null&&B==null){
            return true;
        }
        if(A==B){
            return true;
        }
        if(A.children.containsAll(B.children)){
            return true;
        }
        for(int i = 0; i<A.children.size(); i++){
            return A.payload.equals(B.payload)&&equals(A.children.get(i),B.children.get(i));
        }
        return false;

    }

    /**
     * Conducts a breadth first search on a tree, from top to bottom, left to right.
     *
     * Hint: use a Java Queue, rather than recursion (which depends on the Stack).
     * You can add and remove to the queue using Queue::add(e) and Queue::remove, respectively.
     *
     * @param root Root of the tree.
     * @return List of elements in the tree, in order of BFS search.
     */
    public static LinkedList<Integer> bfs(TreeNode<Integer> root) {
        LinkedList<Integer> depTrai=new LinkedList<>();
        Queue<TreeNode<Integer>> minh= new LinkedList<TreeNode<Integer>>();
        if(root!=null){
            minh.add(root);
        }
        while(!minh.isEmpty()){
           TreeNode<Integer> temp= minh.remove();
           depTrai.add(temp.payload);
           for( int i=0; i<temp.children.size();i++){
               if (temp.children.get(i)!=null){
                   minh.add(temp.children.get(i));
               }
           }
        }

        return depTrai;
    }

    /**
     * Finds the path from a tree root to a target element.
     *
     * Note: unlike BinaryTreeAlgorithms::path, this method returns a list of nodes
     * rather than a list of directions (enums). Furthermore, this method returns
     * an empty list when there is no path, while the BinaryTreeAlgorithms::path method
     * will return null if there is no path.
     *
     * @param root Root of the tree.
     * @param value Value to search for.
     * @return A LinkedList of TreeNodes, starting with the root node, describing the path of nodes
     * from the root to the node containing the target value.
     * If the target element is not present in the tree, return an empty list.
     */
    public static <T> LinkedList<TreeNode<T>> path(TreeNode<T> root, T value) {
        LinkedList<TreeNode<T>> minh= new LinkedList<>();
        if(root==null){
            return new LinkedList<>();
        }
        if(root.payload==value){
            minh.add(root);
        }
        for(TreeNode<T> depTrai: root.children){
            if(!path(depTrai,value).isEmpty()){
                minh.add(root);
                minh.addAll(path(depTrai,value));
            }
        }
      /* YOUR CODE HERE */
        return minh;
    }
}
