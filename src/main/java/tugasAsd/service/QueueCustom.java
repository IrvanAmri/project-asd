package tugasAsd.service;

import java.util.ArrayList;
import java.util.List;

import tugasAsd.models.Posting;

//create queue class with linked list
public class QueueCustom {
    
    private Posting head;
    private int size;

    //create constructor
    public QueueCustom() {
        this.head = null;
        this.size = 0;
    }

    public void addPosting(Posting posting){
        //check if queue is empty
        if (this.head == null) {
            this.head = posting;
        } else {
            //create temporary variable
            Posting temp = this.head;

            //looping until the last node
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            //add new node
            temp.setNext(posting);
        }

        //increase size
        this.size++;
    }

    public Posting pop(){
        //check if queue is empty
        if (this.head == null) {
            return null;
        } else {
            //create temporary variable
            Posting temp = this.head;

            //remove head
            this.head = this.head.getNext();

            //decrease size
            this.size--;

            //return temp
            return temp;
        }
    }

    public Posting peek(){
        //check if queue is empty
        if (this.head == null) {
            return null;
        } else {
            //return head
            return this.head;
        }
    }

    public List<Posting> getAllPosting(){
        //create temporary variable
        Posting temp = this.head;
        List<Posting> postings = new ArrayList<>();

        //looping until the last node
        while (temp != null) {
            postings.add(temp);
            temp = temp.getNext();
        }

        //return postings
        return postings;
    }


    //getter setter

    public Posting getHead() {
        return head;
    }

    public void setHead(Posting head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
