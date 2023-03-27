package tugasAsd.models;

import tugasAsd.service.QueueCustom;

public class Account {
    
    private String username;
    private QueueCustom postingQueue;

    //create constructor
    public Account(String username) {
        this.username = username;
        this.postingQueue = new QueueCustom();
    }

    public void printAccount(){
        System.out.println("-----------------------------");
        System.out.println("Username: " + this.username);
    }


    //getter setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public QueueCustom getPostingQueue() {
        return postingQueue;
    }

    public void setPostingQueue(QueueCustom postingQueue) {
        this.postingQueue = postingQueue;
    }




    
}
