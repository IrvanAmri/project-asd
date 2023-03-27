package tugasAsd.models;

public class Posting {
    
    private String username;
    private String title;
    private String content;
    private Posting next;

    //create constructor
    public Posting(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Posting getNext() {
        return next;
    }

    public void setNext(Posting next) {
        this.next = next;
    }

    public void printPosting(){
        System.out.println("-----------------------------");
        System.out.println("Username: " + this.username);
        System.out.println("Title: " + this.title);
        System.out.println("Content: " + this.content);
    }

}
