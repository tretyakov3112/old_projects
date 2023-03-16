package tretyakov.example.classwork;


import java.util.ArrayList;
import java.util.List;

public class User {


    private String username;
    private List<String> comments;


    public User(String username, List<String> comments) {
        this.username = username;
        this.comments = comments;
    }


    public User() {
        List<String> comments1 = new ArrayList<>();
        comments1.add("wonderful");
        this.username = "Alex";
        this.comments = comments1;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}