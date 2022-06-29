package competition.tencent;

import base.TreeNode;

import java.util.HashMap;

public class Main4 {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);

        TreeNode root2=new TreeNode(2);
        TreeNode root3=new TreeNode(3);
        TreeNode root4=new TreeNode(4);
        TreeNode root5=new TreeNode(5);
        TreeNode root6=new TreeNode(6);
        TreeNode root7=new TreeNode(7);
        root.left=root2;
        root.right=root3;
        root2.left=root4;
        root2.right=root5;
        root3.left=root6;
        root3.right=root7;
        Main4 sss=new Main4();
        TreeNode ans=sss.solve(root,new int[][]{{1,2},{2,3},{1,7}});

    }

    public TreeNode solve (TreeNode root, int[][] b) {
        // write code here
        HashMap<TreeNode,TreeNode> father=new HashMap<>();
        HashMap<Integer,TreeNode> nodes=new HashMap<>();
        father.put(root,null);
        visit(root,father,nodes);

        for(int i=0;i<b.length;i++){
            TreeNode father1=father.get(nodes.get(b[i][0]));
            TreeNode father2=father.get(nodes.get(b[i][1]));
            if(father1!=null&&father2!=null&&father1!=nodes.get(b[i][1])&&father2!=nodes.get(b[i][1])){
                if(father1!=father2){
                    if(father1.left==nodes.get(b[i][0])){
                        father1.left=nodes.get(b[i][1]);
                    }
                    else{
                        father1.right=nodes.get(b[i][1]);
                    }
                    if(father2.left==nodes.get(b[i][1])){
                        father2.left=nodes.get(b[i][0]);
                    }
                    else{
                        father2.right=nodes.get(b[i][0]);
                    }
                }
                else{
                    if(father1.left==nodes.get(b[i][0])){

                        father1.left=nodes.get(b[i][1]);
                        father1.right=nodes.get(b[i][0]);
                    }
                }


            }
        }
        return root;
    }

    public void visit(TreeNode root, HashMap<TreeNode, TreeNode> father,HashMap<Integer,TreeNode> nodes) {
        if(root==null){
            return;
        }
        nodes.put(root.val,root);
        if(root.left!=null){
            father.put(root.left,root);
        }
        visit(root.left,father,nodes);
        if(root.right!=null){
            father.put(root.right,root);
        }
        visit(root.right,father,nodes);

    }


}
