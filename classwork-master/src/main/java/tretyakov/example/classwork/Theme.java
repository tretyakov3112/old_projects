package tretyakov.example.classwork;

import java.util.List;

public class Theme {

    private String theme;
    private List<User> users;


    public Theme(String theme, List<User> users) {
        this.theme = theme;
        this.users = users;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
