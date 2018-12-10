package com.company.Offer.Tree;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/9 上午10:37
 */

public class $7Tree {
    public Node root;

    private class Node{
        private int data;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data) {
            this.data = data;
        }
    }
    /*
    * @description:
    * 根据前序和中序遍历数组，重建二叉树
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public Node construct(int[] pre,int[] in,int len) {
        if(pre == null || in == null || len <= 0){
            return null;
        }
        return constructCore(pre,0,0+len-1,in,0,0+len-1);
    }

    private Node constructCore(int[] pre, int i, int i1, int[] in, int i2, int i3)  {
        // 前序遍历第一个节点是根节点
        int rootValue = pre[i];
        Node root = new Node(rootValue);
        root.parent=root.left=root.right = null;

        if(i == i1){
            if(i2 == i3 && pre[i] == in[i2]){
                return root;
            }
            else{
                try {
                    throw new Exception("");
                } catch (Exception e) {
                }
            }
        }

        // 中序遍历中找到跟节点的值，则根节点左侧为左子树，跟节点右侧为右子树，一次递归建立
        int rootinorder = i2;
        while(rootinorder <= i3 && in[rootinorder] != rootValue){
            ++rootinorder;
        }
        if(rootinorder == i3 && in[rootinorder] != rootValue){
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int leftlen = rootinorder - i2;
        int leftpreorderend = i + leftlen;
        // 构建左子树
        if(leftlen>0){
            root.left = constructCore(pre,i+1,leftpreorderend,in,i2,rootinorder-1);
        }
        // 构建右子树
        if(leftlen < i1 - i){
            root.right = constructCore(pre,leftpreorderend+1,i1,in,rootinorder+1,i3);
        }

        return root;
    }

    /*
    * @description:
    * 查找二叉树的下一节点
    * 给定一颗二叉树和其中一个节点，如何找出中序遍历序列的下一个节点，
    * 树的节点含有左右子节点及其父节点
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public Node findNext(Node node){
        if(node == null){
            return null;
        }
        Node next = null;
        // 如果右子树不为空，则查找右子树的最左子节点
        if(node.right != null){
            Node right = node.right;
            while(right.left != null){
                right = right.left;
            }
            next = right;
            /*
             否则，如果如果当前节点没有右子树，且父节点不空，分两种情况：
             1。当前节点是父节点的左子节点，则下一节点就是父节点
             2。当前节点是父节点的右节点，我们需要沿着父节点一直向上遍历，直到找到一个是它父节点的左子节点的节点，
             如果此节点存在，则是要找的下一个节点
              */

        }else if(node.parent != null){
            Node cur = node;
            Node parent = node.parent;
            while(parent != null && cur == parent.right){
                cur = parent;
                parent = parent.parent;
            }
            next = parent;
        }
        return next;
    }/*
    * @description:
    * $27 二叉树镜像问题
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public void MirrorRecursively(Node node){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            return;
        }

        Node tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        if(node.left != null){
            MirrorRecursively(node.left);
        }
        if(node.right != null){
            MirrorRecursively(node.right);
        }
    }
    /*
    * @description:
    * ¥28 对称二叉树
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public boolean isSymmetrical(Node node){
        return isSymmetrical(node ,node);
    }

    private boolean isSymmetrical(Node node, Node node1) {
        if(node == null && node1 == null){
            return true;
        }
        if(node == null || node == null){
            return false;
        }
        if(node.data != node1.data){
            return true;
        }

        return isSymmetrical(node.left,node1.right)
                && isSymmetrical(node.right,node1.left);
    }
}
