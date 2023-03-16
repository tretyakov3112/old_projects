package tretyakov.example.classwork;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class UserController {
    private List<User> users;
    private List<Theme> themes;

    {
        List<String> comment1 = new ArrayList<>();
        comment1.add("true");
        comment1.add("cool");
        comment1.add("that a pity");

        List<String> comment2 = new ArrayList<>();
        comment1.add("false");
        comment1.add("fallable");
        comment1.add("it does not matter");

        List<String> comment3 = new ArrayList<>();
        comment1.add("aaaaa");
        comment1.add("I don't think so");
        comment1.add("I admired him");

        users = new ArrayList<>();
        users.add(new User());
        users.add(new User("Sergey", comment1));
        users.add(new User("Serginat", comment2));
        users.add(new User("Serg", comment3));

        themes = new ArrayList<>();
        themes.add(new Theme("Global warming", users));
        themes.add(new Theme("Why everyone can be happy", users));
        themes.add(new Theme("Hawking's death", users));


    }

    // curl --get http://localhost:8080/users
    @GetMapping("users")
    public List<Theme> getThemes() {
        return themes;
    }

    // curl --get http://localhost:8080/users/2
    @GetMapping("users/{userIndex}")
    public List<String> getComments(@PathVariable("userIndex") Integer userIndex) {
        return users.get(userIndex).getComments();
    }

    //curl -X POST http://localhost:8080/users/theme/create -H "Content-Type: application/json" -d "{\"theme\":\"comment\"}"
    @PostMapping("users/theme/create")
    public void addComment(@PathVariable("theme") Theme theme, String comment) {
        theme.getUsers().get(0).getComments().add(comment);
    }

    //curl -X DELETE http://localhost:8080/users/delete/2/1
    @DeleteMapping("users/delete/{themeIndex}/{commentIndex}")
    public void removeUserAt(@PathVariable("themeIndex") Integer themeIndex, @PathVariable("commentIndex") Integer commentIndex) {
        themes.get(themeIndex).getUsers().get(0).getComments().remove(commentIndex);
    }
    

    //curl -X PUT http://localhost:8080/users/update/2/1 -H "Content-Type: application/json" -d "{\"theme\": \"comment\"}"
    @PutMapping("users/update/{themeIndex}/{commentIndex}")
    public void updateComment(@PathVariable("themeIndex") Integer themeIndex, @PathVariable("commentIndex") Integer commentIndex, String comment)
    {
        themes.get(themeIndex).getUsers().get(0).getComments().set(commentIndex, comment);
    }

}