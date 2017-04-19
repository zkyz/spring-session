package in.cheoeum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/s")
public class SessionController {

    @GetMapping
    public String get(HttpSession session) {
        StringBuilder info = new StringBuilder();
        info.append(session.getId())
                .append("<hr>")
                .append(session.getAttribute("TEST"))
                .append("<hr>")
                .append(session.getCreationTime());

        return info.toString();
    }

    @GetMapping("/a")
    public String add(@RequestParam String test, HttpSession session) {
        session.setAttribute("TEST", test);
        return "ok!";
    }
}
