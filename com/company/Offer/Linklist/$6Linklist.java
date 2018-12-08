package com.company.Offer.Linklist;/*
 * @description
 * 实现一个单链表的各个常用操作
 * @author : wenhao
 * @create : 2018/12/8 下午10:47
 */

public class $6Linklist {
    private class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    public Node head;
    private int len;
    public $6Linklist() {
    }
    public void addEles(int[] datas){
        for (int data: datas){
            addEle(data);
        }
    }
    public void addEle(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            Node last = findLast();
            last.next = node;
        }
        len++;
    }

    public Node findLast() {
        if(head == null){
            return null;
        }
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        return cur;
    }
    public Node findEle(int data){
        if(head == null){
            return null;
        }
        Node cur = head;
        while(cur.data != data){

            if(cur.next == null){
                return null;
            }else{
                cur = cur.next;
            }
        }
        return cur;
    }
    public void printlistfromlasttofirst(Node cur){
        if(cur == null){
            System.out.print("");
        }else{
            printlistfromlasttofirst(cur.next);
            System.out.print(cur.data+"\t");
        }

    }
    public Node findK_NodefromLast(int k){
        if(getLen()<k || k<0){
            return null;
        }
        Node cur=head;
        Node pre_k = head;
        int i=1;
        while(i++<k){
            cur = cur.next;
        }
        while(cur.next!= null){
            cur = cur.next;
            pre_k = pre_k.next;
        }
        return pre_k;
    }
    public Node reverseList(){
        if(getLen()<2){
            return head;
        }
        Node newhead = null;
        Node cur= head;
        Node pre = null;
        while(cur!=null){
            Node next = cur.next;
            if(next == null){
                newhead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = newhead;
        return newhead;
    }
    public int getLen(){
        return len;
    }
    public boolean delete(int data){
        if(head == null){
            return false;
        }
        if(head.data== data){
            head=head.next;
            return true;
        }
        Node cur=head;
        Node pre = head;
        while(cur != null){

            if(cur.data==data){
                pre.next = cur.next;
                cur = null;
                return true;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return false;
    }
    public void printList(){
        if(head == null){
            return;
        }
        Node cur = head;
        while (cur != null){
            System.out.print(cur.data + "\t");
            cur= cur.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        $6Linklist list = new $6Linklist();
        System.out.println("init len:"+list.getLen());
        list.addEle(1);
        System.out.println(list.findLast().data);
        list.addEles(new int[]{2,3,4,5});
        System.out.println("insert after len:"+list.getLen());
//        System.out.println("delete2:"+list.delete(2));
//        System.out.println("delete20:"+list.delete(20));
//        System.out.println("print from last to index:");
//        list.printlistfromlasttofirst(list.head);
//        System.out.println();
//        System.out.println("reverse before:");
//        list.printList();
//        list.reverseList();
//        System.out.println("reverse after:");
        list.printList();
//        System.out.println("print from last to index:");
//        list.printlistfromlasttofirst(list.head);
        System.out.println("pre 5:"+list.findK_NodefromLast(5).data);
        System.out.println("pre 2:"+list.findK_NodefromLast(2).data);
        System.out.println("pre 0:"+list.findK_NodefromLast(0).data);
    }
}
