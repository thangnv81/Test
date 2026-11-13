/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdfall23_is1804.IOT1801;

/**
 *
 * @author thangnv75
 */
public class Linkedlist {
    Node head, tail;
    public Linkedlist() {
        head = tail = null;
    }
    public void clear() {
        head = tail = null;
    }
    public void display() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println("");
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addHead(int x) {
        Node newnode = new Node(x);
        if (isEmpty()) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }    
    public void addTail(int x) {
        Node newnode = new Node(x);
        if (isEmpty()) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }
    public void insPreLastMin(int x) {
        int pos = findLastMin();
        insertAt(pos, x);
    }
    public void insertlastX(int x, int y) {
        int pos = findLastX(x) ;
        insertAt(pos, x);
    }
    public void insertpre(int x, int y) {
        int t = findfisrtX(y);
        insertAt(t + 1, x);
    }
    public void insertAt(int pos, int x) {
        int count = 0;
        Node p = head;
        if (pos < 0) {
            return;
        }
        if (isEmpty() || pos == 0) {
            addHead(x);
            return;
        }
        while (count < pos - 1 && p != null) {
            count++;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (p == tail) {
            addTail(x);
            return;
        }
        Node newnNode = new Node(x);
        newnNode.next = p.next;
        p.next = newnNode;

    }
    public int findnth(int x,int nth) {
        Node p = head;
        int count = 0, pos = 0;
        while (p != null) {
            if (p.info == x) {
                count++;
            }
            if (count == nth) {
                break;
            }
            p = p.next;
            pos++;
        }
        if (p == null) {
            return -999;
        }
        return pos;
    }
    public int findLastX(int x) {
        Node p = head;
        int count = 0, pos = 0, i = 0;
        while (p != null) {
            if (p.info == x) {
                count++;
                pos = i;
            }
            p = p.next;
            i++;
        }
        if (count == 0) {
            return -999;
        }
        return pos;
    }
    public int findLastMin() {
        int min = head.info;
        Node p = head;
        int pos = 0, i = 0;
        while (p != null) {
            if (p.info <= min) {
                pos = i;
            }
            p = p.next;
            i++;
        }
        return pos;
    }
    public int findfirstmax() {
        int count = 1, pos = 0;
        Node p = head;
        int max = head.info;
        while (p != null) {
            if (p.info > max) {
                max = p.info;
                pos = count;
            }
            count++;
            p = p.next;
        }
        return pos;
    }
    public int findLastMax() {
        int count = 1, pos = 0;
        Node p = head;
        int max = head.info;
        while (p != null) {
            if (p.info >= max) {
                max = p.info;
                pos = count;
            }
            count++;
            p = p.next;
        }
        return pos;
    }
    public int findFirstMin() {
        int count = 0, pos = 0;
        Node p = head;
        int min = head.info;
        while (p != null) {
            if (p.info < min) {
                min = p.info;
                pos = count;
            }
            count++;
            p = p.next;
        }
        return pos;
    }
    public int findfisrtX(int x) {
        Node p = head;
        int pos = 0;
        while (p != null && p.info != x) {
            p = p.next;
            pos++;
        }
        if (p == null) {
            return -999;
        }
        return pos;
    }
    public int findMax(){
       int max=head.info;
       Node p=head;
       while (p!=null){
           if (p.info>max) max=p.info;
           p=p.next;
       }
       return  max;
    }
    public int findMin(){
        int min=head.info;
       Node p=head;
       while (p!=null){
           if (p.info<min) min=p.info;
           p=p.next;
       }
       return  min;
    }
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
    }
    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        Node p = head;
        if (head==tail){
            head=null;
            return;
        }
        while (p.next != tail) {
            p = p.next;
        }
        p.next = null;
        tail = p;
    }
    public void removeAt(int pos) {
        if (isEmpty() || pos < 0) {
            return;
        }
        if (pos == 0) {
            removeFirst();
        } else {
            Node p = head;
            int i = 0;
            while (p != null && i < pos - 1) {
                p = p.next;
                i++;
            }
            if (p == null) {
                return;
            }
            if (p == tail) {
                removeLast();
                return;
            }
            if (p.next==tail) tail=p;
            p.next = p.next.next;

        }

    }
    public void removeFirstMin() {
        int pos = findFirstMin();
        removeAt(pos);
    }
    public void removeLastMin() {
        int pos = findLastMin();
        removeAt(pos);
    }
    public void removeAll(int x) {

        if (isEmpty()) {
            return;
        }
        //xoa cac node dau tien ==x
        while (head.info == x && !isEmpty()) {
            head = head.next;
        }
        //xoa cac node con lai == x
        Node p = head;
        int pos = 0, i = 0;
        while (p != null && p.next != null) {

            if (p.next.info == x) {
                pos = i + 1;
                removeAt(pos);
            }else{
                i++;
                p = p.next;
            }
        }
    }
    public int  getNum(){
        int count=0;
        Node p=head;
        while (p!=null){
            count++;
            p=p.next;
        }
        return count;
    }  
    public void sort() {
        for (Node i = head; i != null; i = i.next) {
            Node min = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (j.info < min.info) {
                    min = j;
                }
            }
            
             if (i!=min){
                int tmp = i.info;
                i.info = min.info;
                min.info = tmp;
            }
        }
    }
    public Node getNode(int x){
        int i=0;
        if (x<0 || x>getNum()) return null;
        Node p=head;
        while (i<x){
            p= p.next;
            i++;
        }
        return p;
    }
    public void sort(Node from, Node to){
       if (from==null   || from==to) return;
       for (Node i = from; i != to; i = i.next) {
            Node min = i;
            for (Node j = i.next; j != to; j = j.next) {
                if (j.info < min.info) {
                    min = j;
                }
            }
            if (i!=min){
                int tmp = i.info;
                i.info = min.info;
                min.info = tmp;
            }
        }
        
    }
    public void update(int pos, int x) {
        if (isEmpty()) {
            return;
        }
        int i = 0;
        Node p = head;
        while (p != null && i < pos) {
            p = p.next;
            i++;
        }
        if (p != null) {
            p.info = x;
        }
    }
    public void updateAll(int x,int y){
        Node p=head;
        while (p!=null){
            if (p.info==x) p.info=y;
            p=p.next;
        }
    }
    public void remove2ndMin(){
        int min =findMin();
        int pos = findnth(min, 2);
        removeAt(pos);
    }
}
