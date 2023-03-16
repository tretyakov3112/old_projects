package tretyakov.example.classwork;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class ApiController {
    private List<String> themes;

    {
        themes = new ArrayList<>();
        themes.add("serg");
        themes.add("serginia");
        themes.add("serginat");
        themes.add("la_serj");
    }

    // curl --get http://localhost:8080/themes
    @GetMapping("themes")
    public List<String> getThemes() {
        return themes;
    }

    //curl --get http://localhost:8080/themes/search/la_serj
    @GetMapping("themes/search/{text}")
    public int getIndexOf(@PathVariable("text") String text) {
        return themes.indexOf(text);
    }

    //curl --get http://localhost:8080/themes/count
    @GetMapping("themes/count")
    public int getSize(){
        return themes.size();
    }

    /* curl -X POST http://localhost:8080/themes -H 'Content-Type:
   text/plain' -d 'text' */
    @PostMapping("themes")
    public void addTheme(@RequestBody String text) {
        themes.add(text);
    }

    // curl --get http://localhost:8080/themes/1
    @GetMapping("themes/{index}")
    public String getTheme(@PathVariable("index") Integer index) {
        return themes.get(index);
    }

    // curl -X POST http://localhost:8080/themes/2/create
    @PostMapping("themes/{index}/create")
    public void addThemeAt(@PathVariable("index") Integer index) {
        themes.add(themes.get(index));
    }

    //curl -X DELETE http://localhost:8080/themes/search/serg
    @DeleteMapping("messages/search/{text}")
    public void deleteAll(@PathVariable("text") String text)
    {
        themes.removeIf(theme -> theme.contains(text));
    }

    // curl -X DELETE http://localhost:8080/themes/1
    @DeleteMapping("messages/{index}")
    public void deleteText(@PathVariable("index") Integer index) {
        themes.remove((int) index);
    }

    //curl --put http://localhost:8080/themes/0 -H 'Content-Type:
    //   text/plain' -d 'la_serj'
    @PutMapping("themes/{index}")
    public void updateMessage(
            @PathVariable("index") Integer i,
            @RequestBody String theme) {
        themes.remove((int) i);
        themes.add(i, theme);
    }
}