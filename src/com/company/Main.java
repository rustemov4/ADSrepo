package com.company;

import java.util.Arrays;
import java.util.List;

class MyLinkedLIst{
    private MyNode head;
    private MyNode tail;
    private int size;
    MyNode GetNode(int data) {
         return new MyNode(data);
     }
     MyNode InsertPos( int position, int data) {
         MyNode headNode = head;
         if (position < 1)
             System.out.print("Invalid position");

         if (position == 1) {
             MyNode newNode = new MyNode(data);
             newNode.next = headNode;
             head = newNode;
         } else {
             while (position-- != 0) {
                 if (position == 1) {

                     MyNode newNode = GetNode(data);

                     newNode.next = headNode.next;

                     headNode.next = newNode;
                     break;
                 }
                 headNode = headNode.next;
             }
             if (position != 1)
                 System.out.print("Position out of range");
         }
         return head;
     }
    public int get(int index){
    MyNode current = head;
    for(int i = 0; i < index-1; i++){
        current = current.next;
    }
    return current.data;
    }
     public boolean search(int x)
     {
         MyNode current = head;
         while (current != null)
         {
             if (current.data == x)
                 return true;
             current = current.next;
         }
         return false;
     }

     void deleteNode(int position)
     {

         if (head == null)
             return;

         MyNode temp = head;


         if (position == 0)
         {
             head = temp.next;
             return;
         }

         for (int i=0; temp!=null && i<position-1; i++)
             temp = temp.next;


         if (temp == null || temp.next == null)
             return;

         MyNode next = temp.next.next;

         temp.next = next;
     }
    class MyNode{
        int data;
        MyNode next;
        MyNode(int data){
            this.data = data;
            next = null;
        }
    }

}
class ArrayList<T>{
    private int size;
     Object[] insert(Object[] a, T key, int index)
    {
        Object[] result = new Object[a.length + 1];

        for (int i = 0; i < index; i++) {
            result[i] = a[i];
        }

        result[index] = key;

        for (int i = index + 1; i <= a.length; i++) {
            result[i] = a[i - 1];
        }
        size++;
        return result;
    }
    void print(Object a[],int size){
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
    }
    public  Object removeTheElement(Object[] arr,
                                         int index)
    {
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }

        Object[] anotherArray = new Object[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
    public int getSize(){
         return size;
    }
    public int find(Object a[],T res){
        for (int i =0; i < size-1;i++) {
            if (a[i].equals(res)) {
                return 1;
            }
        }
        return -1;
    }
}

public class Main
{
    public static void main(String[] args) {
        MyLinkedLIst myLinkedLIst = new MyLinkedLIst();
/*
        myLinkedLIst.InsertPos(1,1);
        myLinkedLIst.InsertPos(2,2);
        myLinkedLIst.InsertPos(3,3);
        myLinkedLIst.InsertPos(4,4);

 */

        ArrayList <Integer>arraylist = new ArrayList();
        Object[] a = { 1, 2, 4, 5 };
        int key =  3;
        int index = 2;
        a = arraylist.insert(a, key, index);
        int size = a.length;
        arraylist.print(a,size);
        System.out.println();
        a = (Object[]) arraylist.removeTheElement(a,2);
        System.out.println("Resultant Array: "
                + Arrays.toString(a));
    }
}

