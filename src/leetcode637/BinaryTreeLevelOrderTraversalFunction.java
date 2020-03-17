package leetcode637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversalFunction {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        
        // Using a queue for bfs (level order)
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null){
            return result;
        }
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            
            for(int i = 0; i < size; i++){
                TreeNode current = queue.remove();
                
                sum += current.val;
                
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            
            // sum/size since size is the number of elements of this level
            result.add(sum/size);
        }
        
        return result;
    }
}
